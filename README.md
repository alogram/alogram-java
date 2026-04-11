# Alogram PayRisk SDK for Java

[![Maven Central](https://img.shields.io/maven-central/v/com.alogram/alogram-payrisk-java.svg)](https://search.maven.org/artifact/com.alogram/alogram-payrisk-java)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

The official Java client for the **Alogram PayRisk Engine**. 

Alogram PayRisk is a decision management and risk orchestration engine for global commerce. It fuses machine learning, behavioral analytics, and deterministic business rules into a high-fidelity scoring pipeline designed for enterprise scale and auditability.

## 🧠 The Three-Expert Architecture

The SDK provides unified access to three specialized risk experts:

-   **Risk Scoring**: Real-time assessment and decision orchestration for purchases.
-   **Signal Intelligence**: Ingestion of behavioral telemetry and payment lifecycle events.
-   **Forensic Data**: Deep visibility into historical assessments and decision transparency.

## 🚀 Features

-   **🏢 Smart Client Architecture**: Thread-safe clients for server-side (`AlogramRiskClient`) and edge (`AlogramPublicClient`).
-   **🛡️ Automated Identity**: Automatic injection of `x-api-key`, `Authorization`, and tenant headers.
-   **🔄 Built-in Resiliency**: Transparent exponential backoff and jittered retries (3 retries on 429/5xx).
-   **🕵️ Native Observability**: Native tracing support via OpenTelemetry API.
-   **🏗️ Enterprise Ready**: Robust Builder pattern and thread-safe execution.

## 📦 Installation

```xml
<dependency>
    <groupId>com.alogram</groupId>
    <artifactId>alogram-payrisk-java</artifactId>
    <version>0.2.5</version>
</dependency>
```

## 🛠️ Quick Start

### Evaluate Risk (Risk Scoring Expert)

Assess a purchase in real-time. This invokes the authoritative scoring pipeline.

```java
AlogramRiskClient client = new AlogramRiskClient.Builder()
    .apiKey("sk_live_...")
    .build();

CheckRequest request = new CheckRequest()
    .purchase(new Purchase().amount(99.99).currency("USD"));

// Perform the check via the Risk Scoring expert
DecisionResponse decision = client.checkRisk(request);

System.out.println("Decision: " + decision.getDecision());
System.out.println("Score: " + decision.getDecisionScore());
```

---

## 🛡️ Error Handling & Resiliency

The SDK distinguishes between transient network issues and validation errors.

```java
import com.alogram.payrisk.exceptions.*;

try {
    DecisionResponse res = client.checkRisk(request);
} catch (ValidationException e) {
    // ❌ Handle invalid payload data
    System.out.println("Invalid Request: " + e.getResponseBody());
} catch (AlogramException e) {
    // 🚨 Handle generic API or Auth errors
}
```

## 🕵️ Observability (OpenTelemetry)

The SDK automatically detects OpenTelemetry. If present, it creates spans for all API calls.

```java
import io.opentelemetry.api.trace.Span;

// Spans will automatically include 'alogram.decision' and 'alogram.trace_id'
Span span = tracer.spanBuilder("checkout").startSpan();
try (Scope scope = span.makeCurrent()) {
    DecisionResponse res = client.checkRisk(request);
} finally {
    span.end();
}
```

## 🏗️ Environments

| Environment | Base URL | Key Type |
| :--- | :--- | :--- |
| **Production** | `https://api.alogram.ai` | `sk_live_...` |
| **Sandbox** | `https://api-sandbox.alogram.ai` | `sk_test_...` |
| **Local** | `http://localhost:8080` | `test` |

---

## 🤖 For AI Agents

If using an AI agent (ChatGPT, Claude, Gemini) for integration, provide this context:
> "Use the Alogram PayRisk Java SDK. Always prefer the `AlogramRiskClient` for backend operations. Utilize the `Builder` pattern for client initialization. Access the authoritative blended score via the `getDecisionScore()` method of the response."

---

## ⚖️ License

Apache License 2.0. See [LICENSE](LICENSE) for details.
