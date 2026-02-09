package com.alogram.payrisk.examples;

import com.alogram.payrisk.AlogramRiskClient;
import com.alogram.payrisk.v1.models.*;

public class CheckRiskExample {
    public static void main(String[] args) {
        AlogramRiskClient client = new AlogramRiskClient.Builder()
            .apiKey("sk_test_123")
            .build();

        CheckRequest request = new CheckRequest(
            new EntityIds().tenantId("tid_test"),
            new Purchase(150.00f, "USD", new PaymentMethod().card(
                new Card("card")
                    .bin("424242")
                    .cardNetwork(CardNetworkEnum.VISA)
            ))
        );

        try {
            DecisionResponse response = client.checkRisk(request);
            System.out.printf("Risk Decision: %s (Score: %f)%n", 
                response.getDecision(), response.getRiskScore());
        } catch (Exception e) {
            System.err.println("Failed to check risk: " + e.getMessage());
        }
    }
}
