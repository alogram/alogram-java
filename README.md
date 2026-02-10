# Alogram Payrisk Java SDK

[![Maven Central](https://img.shields.io/maven-central/v/com.alogram/alogram-payrisk.svg)](https://central.sonatype.com/artifact/com.alogram/alogram-payrisk)
[![License: Apache 2.0](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

The official Java client for the **Alogram Payments Risk API**. This SDK provides a robust, "smart" interface for checking fraud risk, ingesting behavioral signals, and managing payment lifecycle events.

**Key Features:**
*   **Resilient:** Built-in retries with exponential backoff using **Failsafe**.
*   **Traceable:** Automatic injection of `x-trace-id` and `x-idempotency-key` for every request.
*   **Observable:** First-class support for **OpenTelemetry** spans and attributes.
*   **Type-Safe:** Fully typed request/response models.
*   **Secure:** Built-in webhook signature verification.

---

## 🏗️ Installation

### Maven
```xml
<dependency>
    <groupId>com.alogram</groupId>
    <artifactId>alogram-payrisk</artifactId>
    <version>0.1.6-rc.2</version>
</dependency>
```

### Gradle
```gradle
implementation 'com.alogram:alogram-payrisk:0.1.6-rc.2'
```

---

## 🚀 Quickstart

### 1. Initialize the Client

```java
import com.alogram.payrisk.AlogramRiskClient;

AlogramRiskClient client = new AlogramRiskClient.Builder()
    .baseUrl("https://api.alogram.ai")
    .apiKey("sk_live_...")
    .tenantId("your_tenant_id")
    .build();
```

### 2. Check Risk

```java
import com.alogram.payrisk.v1.models.*;

CheckRequest request = new CheckRequest(
    new EntityIds().tenantId("tenant_123"),
    new Purchase(99.00f, "USD", new PaymentMethod().card(new Card("card").bin("424242")))
);

try {
    DecisionResponse response = client.checkRisk(request);
    System.out.println("Decision: " + response.getDecision());
} catch (Exception e) {
    e.printStackTrace();
}
```

---

## 📊 Observability (OpenTelemetry)

The SDK uses the standard OpenTelemetry Java API. It will automatically detect and use the `GlobalOpenTelemetry` instance if configured.

**Captured Attributes:**
*   `alogram.idempotency_key`
*   `alogram.trace_id`
*   `alogram.decision`

---

## 🛡️ Webhook Security

Verify incoming webhooks using the built-in `WebhookVerifier`.

```java
import com.alogram.payrisk.WebhookVerifier;

boolean isValid = WebhookVerifier.verify(payloadBytes, signatureHeader, webhookSecret);
```

---

## ⚠️ Error Handling

| Exception | Description |
| :--- | :--- |
| `AuthenticationException` | Invalid API Key or Permissions. |
| `ValidationException` | Invalid request body or missing fields. |
| `RateLimitException` | Too many requests. **Automatically Retried.** |
| `InternalServerException` | Server-side issues. **Automatically Retried.** |

---

## 📦 License

Apache 2.0
