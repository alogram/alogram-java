package com.alogram.payrisk;

import com.alogram.payrisk.exceptions.*;
import com.alogram.payrisk.v1.models.*;
import com.alogram.v1.client.ApiException;
import dev.failsafe.Failsafe;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;

/**
 * 🌐 **AlogramPublicClient** (Public Client)
 * Designed for client-side environments (Browsers, Mobile) using a Publishable Key (`pk_...`).
 */
public class AlogramPublicClient extends AlogramBaseClient {

    public static class Builder {
        private final AlogramClientOptions options = new AlogramClientOptions();

        public Builder baseUrl(String baseUrl) { options.baseUrl = baseUrl; return this; }
        public Builder apiKey(String apiKey) { options.apiKey = apiKey; return this; }
        public Builder accessToken(String accessToken) { options.accessToken = accessToken; return this; }
        public Builder tenantId(String tenantId) { options.tenantId = tenantId; return this; }
        public Builder clientId(String clientId) { options.clientId = clientId; return this; }
        public Builder debug(boolean debug) { options.debug = debug; return this; }

        public AlogramPublicClient build() {
            if (options.apiKey != null && options.apiKey.startsWith("sk_")) {
                throw new ScopedAccessException("Cannot initialize AlogramPublicClient with a Secret Key (sk_...). " +
                        "Please use AlogramRiskClient.");
            }
            return new AlogramPublicClient(options);
        }
    }

    private AlogramPublicClient(AlogramClientOptions options) {
        super(options);
    }

    public void ingestSignals(SignalsRequest request) {
        ingestSignals(request, null, null);
    }

    public void ingestSignals(SignalsRequest request, String idempotencyKey, String traceId) {
        String ik = ensureId(idempotencyKey);
        String tid = ensureId(traceId);

        Span span = TRACER.spanBuilder("alogram.ingest_signals")
                .setAttribute("alogram.idempotency_key", ik)
                .setAttribute("alogram.trace_id", tid)
                .startSpan();

        try {
            Failsafe.with(retryPolicy).run(() -> {
                try {
                    payriskApi.ingestSignals(ik, request, tid);
                    span.setStatus(StatusCode.OK);
                } catch (ApiException e) {
                    throw mapException(e);
                }
            });
        } catch (Exception e) {
            span.recordException(e);
            span.setStatus(StatusCode.ERROR, e.getMessage());
            throw e;
        } finally {
            span.end();
        }
    }
}
