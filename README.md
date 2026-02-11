# Alogram PayRisk SDK for Java

[![Maven Central](https://img.shields.io/maven-central/v/com.alogram/alogram-payrisk-java.svg)](https://search.maven.org/artifact/com.alogram/alogram-payrisk-java)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

The official Alogram PayRisk 'Smart' SDK for Java. Designed for enterprise financial systems that require high resiliency, thread-safe performance, and native observability.

## 🚀 Features

-   **🏢 Smart Client Architecture**: Thread-safe clients for server-side (`AlogramRiskClient`) and edge (`AlogramPublicClient`).
-   **🛡️ Automated Identity**: Automatic injection of `x-api-key`, `Authorization`, and tenant headers.
-   **🔄 Built-in Resiliency**: Transparent exponential backoff and jittered retries (3 retries on 429/5xx).
-   **🕵️ OpenTelemetry Ready**: Native tracing support via OpenTelemetry API.

## 📦 Installation

```xml
<dependency>
    <groupId>com.alogram</groupId>
    <artifactId>alogram-payrisk-java</artifactId>
    <version>0.1.6-rc.8</version>
</dependency>
```

## 🛠️ Quick Start

### Evaluate Risk (Server-Side)

```java
AlogramRiskClient client = new AlogramRiskClient.Builder()
    .apiKey("sk_live_your_secret_key")
    .build();

CheckRequest request = new CheckRequest()
    .purchase(new Purchase().amount(99.99).currency("USD"));

DecisionResponse decision = client.checkRisk(request);
System.out.println("Decision: " + decision.getDecision());
```

---

## 🛡️ Error Handling

Handle specific API exceptions to ensure transaction continuity:

```java
import com.alogram.payrisk.exceptions.*;

try {
    DecisionResponse res = client.checkRisk(request);
} catch (RateLimitException e) {
    // 🔄 Standard retries are handled by Failsafe inside the SDK
} catch (ValidationException e) {
    // ❌ Handle invalid payload data
    System.out.println(e.getResponseBody());
} catch (AlogramException e) {
    // 🚨 Generic SDK error
}
```

## 🔑 Authentication & Keys

Obtain your keys from the [Alogram Dashboard](https://dashboard.alogram.ai/keys).

| Key Type | Prefix | Client | Use Case |
| :--- | :--- | :--- | :--- |
| **Secret Key** | `sk_live_...` | `AlogramRiskClient` | Server-side risk checks. **Never expose.** |
| **Publishable Key** | `pk_live_...` | `AlogramPublicClient` | Frontend behavioral signals. |

## 🤖 For AI Agents (Integration Context)

If you are using an AI agent (like ChatGPT, Claude, or Gemini), provide this context:

> "I am integrating the Alogram PayRisk Java SDK. I need to call `checkRisk` in my Spring Boot controller. Use the `AlogramRiskClient`, handle `RateLimitException` gracefully, and ensure you use the `idempotencyKey` and `Builder` pattern."

---

## 🧪 Local Testing & Mocking

Use the zero-dependency `MockRiskClient` for JUnit tests:

```java
MockRiskClient mock = new MockRiskClient();
mock.queueDecision("decline", 0.95, "high_risk_ip");

DecisionResponse decision = myApp.process(mock);
System.out.println(decision.getDecision()); // "decline"
```

## 🏗️ Environment Testing

### Alogram Sandbox
For safe integration testing, point your client to the Sandbox environment:
```java
AlogramRiskClient client = new AlogramRiskClient.Builder()
    .apiKey("sk_test_...")
    .baseUrl("https://api-sandbox.alogram.ai")
    .build();
```

### Local Emulator
For hermetic local testing, run the **Alogram Local Emulator**:
```bash
docker run -p 8080:8080 alogram/payrisk-emulator
```
Point your client to the local instance:
```java
AlogramRiskClient client = new AlogramRiskClient.Builder()
    .baseUrl("http://localhost:8080")
    .apiKey("test")
    .build();
```

---

## 📚 Documentation

For full API reference, visit [docs.alogram.ai](https://docs.alogram.ai).

## ⚖️ License

Apache License 2.0. See [LICENSE](LICENSE) for details.
