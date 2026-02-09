package com.alogram.payrisk;

import com.alogram.payrisk.exceptions.*;
import com.alogram.payrisk.v1.models.*;
import com.alogram.v1.client.ApiException;
import dev.failsafe.Failsafe;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;

/**
 * 🏢 **AlogramRiskClient** (Secret Client)
 * Designed for server-side environments using a Secret Key (`sk_...`).
 */
public class AlogramRiskClient extends AlogramBaseClient {

    public static class Builder {
        private final AlogramClientOptions options = new AlogramClientOptions();

        public Builder baseUrl(String baseUrl) { options.baseUrl = baseUrl; return this; }
        public Builder apiKey(String apiKey) { options.apiKey = apiKey; return this; }
        public Builder accessToken(String accessToken) { options.accessToken = accessToken; return this; }
        public Builder tenantId(String tenantId) { options.tenantId = tenantId; return this; }
        public Builder clientId(String clientId) { options.clientId = clientId; return this; }
        public Builder debug(boolean debug) { options.debug = debug; return this; }

        public AlogramRiskClient build() {
            if (options.apiKey != null && options.apiKey.startsWith("pk_")) {
                throw new ScopedAccessException("Cannot initialize AlogramRiskClient with a Publishable Key (pk_...). " +
                        "Please use AlogramPublicClient.");
            }
            return new AlogramRiskClient(options);
        }
    }

    private AlogramRiskClient(AlogramClientOptions options) {
        super(options);
    }

    public DecisionResponse checkRisk(CheckRequest request) {
        return checkRisk(request, null, null);
    }

    public DecisionResponse checkRisk(CheckRequest request, String idempotencyKey, String traceId) {
        String ik = ensureId(idempotencyKey);
        String tid = ensureId(traceId);

        Span span = TRACER.spanBuilder("alogram.check_risk")
                .setAttribute("alogram.idempotency_key", ik)
                .setAttribute("alogram.trace_id", tid)
                .startSpan();

        try {
            return Failsafe.with(retryPolicy).get(() -> {
                try {
                    DecisionResponse response = payriskApi.riskCheck(ik, request, tid);
                    span.setStatus(StatusCode.OK);
                    if (response.getDecision() != null) {
                        span.setAttribute("alogram.decision", String.valueOf(response.getDecision()));
                    }
                    return response;
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

    public void ingestEvent(PaymentEvent event) {
        ingestEvent(event, null, null);
    }

    public void ingestEvent(PaymentEvent event, String idempotencyKey, String traceId) {
        String ik = ensureId(idempotencyKey);
        String tid = ensureId(traceId);

        Span span = TRACER.spanBuilder("alogram.ingest_event")
                .setAttribute("alogram.idempotency_key", ik)
                .setAttribute("alogram.trace_id", tid)
                .startSpan();

        try {
            Failsafe.with(retryPolicy).run(() -> {
                try {
                    payriskApi.ingestPaymentEvent(ik, event, tid);
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
