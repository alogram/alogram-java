// Copyright (c) 2025 Alogram Inc.
// All rights reserved.

package com.alogram.payrisk.testing;

import com.alogram.payrisk.v1.models.*;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 🛠️ **MockRiskClient**
 * 
 * A zero-dependency mock implementation of the Alogram Risk Client for local testing.
 */
public class MockRiskClient {
    private final List<Map<String, Object>> calls = Collections.synchronizedList(new ArrayList<>());
    private final Queue<Object> queuedResponses = new ConcurrentLinkedQueue<>();
    private String defaultDecision = "approve";
    private double defaultScore = 0.1;
    private long delayMs = 0;

    public void setDefaultDecision(String decision, double score) {
        this.defaultDecision = decision;
        this.defaultScore = score;
    }

    private String getTimestamp() {
        return OffsetDateTime.now().format(DateTimeFormatter.ISO_INSTANT);
    }

    public void queueDecision(String decision, double score, String reason) {
        DecisionResponse resp = new DecisionResponse();
        resp.setDecision(DecisionResponse.DecisionEnum.fromValue(decision.toLowerCase()));
        resp.setDecisionAt(getTimestamp());
        resp.setRiskScore((float)score);
        resp.setAssessmentId("mock-" + UUID.randomUUID().toString().substring(0, 12));
        
        FraudScore fs = new FraudScore();
        fs.setRiskLevel(RiskLevelEnum.LOW);
        fs.setScore((float)score);
        fs.setExplanation("Mocked response");
        resp.setFraudScore(fs);

        if (reason != null) {
            ReasonDetail rd = new ReasonDetail();
            rd.setCode("MOCK_CODE");
            rd.setCategory(RiskCategoryEnum.fromValue("behavior"));
            rd.setDisplayName("Mock Reason");
            rd.setDescription(reason);
            resp.setReasons(Collections.singletonList(rd));
        }
        queuedResponses.add(resp);
    }

    public void queueError(RuntimeException exception) {
        queuedResponses.add(exception);
    }

    public void setDelay(long ms) {
        this.delayMs = ms;
    }

    public int getCallCount() {
        return calls.size();
    }

    public List<Map<String, Object>> getCalls() {
        return calls;
    }

    private void handleCall(String method, Object request) {
        Map<String, Object> call = new HashMap<>();
        call.put("method", method);
        call.put("request", request);
        call.put("timestamp", System.currentTimeMillis());
        calls.add(call);

        if (delayMs > 0) {
            try { Thread.sleep(delayMs); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }

    public DecisionResponse checkRisk(CheckRequest request) {
        handleCall("checkRisk", request);
        
        Object item = queuedResponses.poll();
        if (item instanceof RuntimeException) {
            throw (RuntimeException) item;
        }
        if (item instanceof DecisionResponse) {
            return (DecisionResponse) item;
        }

        DecisionResponse fallback = new DecisionResponse();
        fallback.setDecision(DecisionResponse.DecisionEnum.fromValue(defaultDecision.toLowerCase()));
        fallback.setDecisionAt(getTimestamp());
        fallback.setRiskScore((float)defaultScore);
        fallback.setAssessmentId("mock-" + UUID.randomUUID().toString().substring(0, 12));
        
        FraudScore fs = new FraudScore();
        fs.setRiskLevel(RiskLevelEnum.LOW);
        fs.setScore((float)defaultScore);
        fallback.setFraudScore(fs);

        ReasonDetail rd = new ReasonDetail();
        rd.setCode("DEFAULT");
        rd.setCategory(RiskCategoryEnum.fromValue("behavior"));
        rd.setDisplayName("Default");
        rd.setDescription("default_mock_response");
        fallback.setReasons(Collections.singletonList(rd));

        return fallback;
    }

    public void ingestSignals(SignalsRequest request) {
        handleCall("ingestSignals", request);
        Object item = queuedResponses.poll();
        if (item instanceof RuntimeException) throw (RuntimeException) item;
    }

    public void ingestEvent(PaymentEvent event) {
        handleCall("ingestEvent", event);
        Object item = queuedResponses.poll();
        if (item instanceof RuntimeException) throw (RuntimeException) item;
    }
}