package com.alogram.payrisk;

import com.alogram.payrisk.exceptions.AuthenticationException;
import com.alogram.payrisk.exceptions.ScopedAccessException;
import com.alogram.payrisk.v1.models.CheckRequest;
import com.alogram.payrisk.v1.models.DecisionResponse;
import com.alogram.payrisk.v1.models.EntityIds;
import com.alogram.payrisk.v1.models.Purchase;
import com.alogram.payrisk.v1.models.PaymentMethod;
import com.alogram.payrisk.v1.models.Card;
import com.alogram.payrisk.v1.models.SignalsRequest;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class AlogramRiskClientTest {
    private MockWebServer server;

    @BeforeEach
    void setUp() throws IOException {
        server = new MockWebServer();
        server.start();
    }

    @AfterEach
    void tearDown() throws IOException {
        server.shutdown();
    }

    private CheckRequest createTestRequest() {
        return new CheckRequest()
                .entities(new EntityIds().tenantId("tid_123"))
                .purchase(new Purchase()
                        .amount(99.00f)
                        .currency("USD")
                        .paymentMethod(new PaymentMethod(
                                new Card().type(Card.TypeEnum.CARD).bin("424242"))));
    }

    @Test
    void testDualTrustInitialization() {
        // Risk client blocks pk_
        assertThrows(ScopedAccessException.class, () ->
            new AlogramRiskClient.Builder().apiKey("pk_test").build()
        );

        // Public client blocks sk_
        assertThrows(ScopedAccessException.class, () ->
            new AlogramPublicClient.Builder().apiKey("sk_test").build()
        );
    }

    @Test
    void testCheckRiskSuccess() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("{\"decision\": \"approve\", \"riskScore\": 0.1}"));

        AlogramRiskClient client = new AlogramRiskClient.Builder()
                .baseUrl(server.url("/").toString())
                .apiKey("sk_test")
                .build();

        CheckRequest request = createTestRequest();
        DecisionResponse response = client.checkRisk(request);
        assertEquals("approve", String.valueOf(response.getDecision()));

        RecordedRequest recordedRequest = server.takeRequest();
        assertEquals("sk_test", recordedRequest.getHeader("x-api-key"));
    }

    @Test
    void testPublicClientIngestSignals() throws InterruptedException {
        server.enqueue(new MockResponse().setResponseCode(202));

        AlogramPublicClient client = new AlogramPublicClient.Builder()
                .baseUrl(server.url("/").toString())
                .apiKey("pk_test")
                .build();

        client.ingestSignals(new SignalsRequest());
        assertEquals(1, server.getRequestCount());
    }
}
