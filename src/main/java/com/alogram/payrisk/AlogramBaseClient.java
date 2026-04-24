package com.alogram.payrisk;

import com.alogram.payrisk.exceptions.*;
import com.alogram.payrisk.v1.api.PayriskApi;
import com.alogram.payrisk.v1.models.*;
import com.alogram.v1.client.ApiClient;
import com.alogram.v1.client.ApiException;
import com.alogram.v1.client.Configuration;
import dev.failsafe.Failsafe;
import dev.failsafe.RetryPolicy;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;

import java.time.Duration;
import java.util.UUID;
import java.net.http.HttpRequest;
import java.util.function.Consumer;

/**
 * 🔒 Internal base class for shared Java SDK logic.
 */
abstract class AlogramBaseClient {
    protected static final Tracer TRACER = GlobalOpenTelemetry.getTracer("alogram.payrisk");
    
    protected final ApiClient apiClient;
    protected final PayriskApi payriskApi;
    protected final RetryPolicy<Object> retryPolicy;

    protected AlogramBaseClient(AlogramClientOptions options) {
        this.apiClient = Configuration.getDefaultApiClient();
        this.apiClient.updateBaseUri(options.baseUrl);

        this.apiClient.setRequestInterceptor(requestBuilder -> {
            if (options.apiKey != null) {
                requestBuilder.header("x-api-key", options.apiKey);
            }
            if (options.accessToken != null) {
                requestBuilder.header("Authorization", "Bearer " + options.accessToken);
            }
            if (options.tenantId != null) {
                requestBuilder.header("x-trusted-tenant-id", options.tenantId);
            }
            if (options.clientId != null) {
                requestBuilder.header("x-trusted-client-id", options.clientId);
            }
            
            if (options.debug) {
                System.out.println("🚀 Alogram SDK Request: " + requestBuilder.build().uri());
            }
        });

        this.payriskApi = new PayriskApi(this.apiClient);

        this.retryPolicy = RetryPolicy.builder()
                .handleIf(e -> isRetryable((Exception) e))
                .withDelay(Duration.ofSeconds(1))
                .withMaxRetries(2)
                .withBackoff(Duration.ofSeconds(1), Duration.ofSeconds(10))
                .withJitter(0.2)
                .build();
    }

    /**
     * 🚀 Intelligent Handshake: Wait for the infrastructure to wake up.
     * This sends lightweight health checks with exponential backoff to warm up
     * Cloud Run instances and Load Balancer proxies before actual testing.
     */
    public boolean waitForReady(long timeoutSecs) {
        System.out.println("⏳ Performing JVM infrastructure handshake (timeout: " + timeoutSecs + "s)...");
        long startTime = System.currentTimeMillis();
        int attempt = 1;

        while ((System.currentTimeMillis() - startTime) < (timeoutSecs * 1000)) {
            try {
                // Lightweight GET /v1/health
                payriskApi.healthCheck();
                System.out.println("✅ Infrastructure is READY.");
                return true;
            } catch (Exception e) {
                long waitTime = (long) Math.min(Math.pow(2, attempt), 10);
                System.out.println("⚠️ Handshake attempt " + attempt + " failed: " + e.getMessage() + ". Retrying in " + waitTime + "s...");
                try {
                    Thread.sleep(waitTime * 1000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    return false;
                }
                attempt++;
            }
        }

        System.err.println("❌ Infrastructure handshake TIMEOUT.");
        return false;
    }

    private boolean isRetryable(Exception e) {
        if (e instanceof ApiException) {
            int code = ((ApiException) e).getCode();
            return code == 429 || code >= 500;
        }
        if (e instanceof AlogramException) {
            int code = ((AlogramException) e).getStatusCode();
            return code == 429 || code >= 500;
        }
        return false;
    }

    protected AlogramException mapException(ApiException e) {
        int code = e.getCode();
        String body = e.getResponseBody();
        String msg = e.getMessage();

        if (code == 401) return new AuthenticationException(msg, code, body);
        if (code == 403) return new ScopedAccessException(msg);
        if (code == 429) return new RateLimitException(msg, code, body);
        if (code == 400 || code == 422) return new ValidationException(msg, code, body);
        if (code >= 500) return new InternalServerException(msg, code, body);
        
        return new AlogramException(msg, code, body);
    }

    protected String ensureId(String id) {
        return (id == null || id.isEmpty()) ? UUID.randomUUID().toString() : id;
    }
}
