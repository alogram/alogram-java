# PayriskApi

All URIs are relative to *https://api-dev.alogram.ai/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**accountRiskCheck**](PayriskApi.md#accountRiskCheck) | **POST** /v1/risk/account/check | Synchronous fraud decision for account/session events (signup, login, settings) |
| [**accountRiskCheckWithHttpInfo**](PayriskApi.md#accountRiskCheckWithHttpInfo) | **POST** /v1/risk/account/check | Synchronous fraud decision for account/session events (signup, login, settings) |
| [**getFraudScores**](PayriskApi.md#getFraudScores) | **GET** /v1/scores/{tenantId} | Retrieve fraud scores for a customer |
| [**getFraudScoresWithHttpInfo**](PayriskApi.md#getFraudScoresWithHttpInfo) | **GET** /v1/scores/{tenantId} | Retrieve fraud scores for a customer |
| [**healthCheck**](PayriskApi.md#healthCheck) | **GET** /v1/health | Health check for the service |
| [**healthCheckWithHttpInfo**](PayriskApi.md#healthCheckWithHttpInfo) | **GET** /v1/health | Health check for the service |
| [**ingestPaymentEvent**](PayriskApi.md#ingestPaymentEvent) | **POST** /v1/events | Ingest payment lifecycle events (authorization, capture, settlement, refund, dispute, chargeback, chargeback_outcome).  |
| [**ingestPaymentEventWithHttpInfo**](PayriskApi.md#ingestPaymentEventWithHttpInfo) | **POST** /v1/events | Ingest payment lifecycle events (authorization, capture, settlement, refund, dispute, chargeback, chargeback_outcome).  |
| [**ingestSignals**](PayriskApi.md#ingestSignals) | **POST** /v1/signals | Ingest non-payment signals (account or interaction) for modeling |
| [**ingestSignalsWithHttpInfo**](PayriskApi.md#ingestSignalsWithHttpInfo) | **POST** /v1/signals | Ingest non-payment signals (account or interaction) for modeling |
| [**kycRiskCheck**](PayriskApi.md#kycRiskCheck) | **POST** /v1/risk/kyc/check | Synchronous decision for KYC/identity verification |
| [**kycRiskCheckWithHttpInfo**](PayriskApi.md#kycRiskCheckWithHttpInfo) | **POST** /v1/risk/kyc/check | Synchronous decision for KYC/identity verification |
| [**riskCheck**](PayriskApi.md#riskCheck) | **POST** /v1/risk/check | Synchronous fraud decision for a purchase |
| [**riskCheckWithHttpInfo**](PayriskApi.md#riskCheckWithHttpInfo) | **POST** /v1/risk/check | Synchronous fraud decision for a purchase |



## accountRiskCheck

> DecisionResponse accountRiskCheck(xIdempotencyKey, accountCheckRequest, xTraceId)

Synchronous fraud decision for account/session events (signup, login, settings)

### Example

```java
// Import classes:
import com.alogram.v1.client.ApiClient;
import com.alogram.v1.client.ApiException;
import com.alogram.v1.client.Configuration;
import com.alogram.v1.client.auth.*;
import com.alogram.v1.client.models.*;
import com.alogram.payrisk.v1.api.PayriskApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api-dev.alogram.ai/v1");
        
        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        // Configure OAuth2 access token for authorization: oAuth2
        OAuth oAuth2 = (OAuth) defaultClient.getAuthentication("oAuth2");
        oAuth2.setAccessToken("YOUR ACCESS TOKEN");

        PayriskApi apiInstance = new PayriskApi(defaultClient);
        String xIdempotencyKey = "xIdempotencyKey_example"; // String | Unique Idempotency-Key sent in the POST request etc.
        AccountCheckRequest accountCheckRequest = new AccountCheckRequest(); // AccountCheckRequest | 
        String xTraceId = "xTraceId_example"; // String | Echoed or generated trace ID for tracking requests.
        try {
            DecisionResponse result = apiInstance.accountRiskCheck(xIdempotencyKey, accountCheckRequest, xTraceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PayriskApi#accountRiskCheck");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **xIdempotencyKey** | **String**| Unique Idempotency-Key sent in the POST request etc. | |
| **accountCheckRequest** | [**AccountCheckRequest**](AccountCheckRequest.md)|  | |
| **xTraceId** | **String**| Echoed or generated trace ID for tracking requests. | [optional] |

### Return type

[**DecisionResponse**](DecisionResponse.md)


### Authorization

[ApiKey](../README.md#ApiKey), [oAuth2](../README.md#oAuth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Synchronous risk decision. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **400** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **422** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **429** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **500** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |

## accountRiskCheckWithHttpInfo

> ApiResponse<DecisionResponse> accountRiskCheck accountRiskCheckWithHttpInfo(xIdempotencyKey, accountCheckRequest, xTraceId)

Synchronous fraud decision for account/session events (signup, login, settings)

### Example

```java
// Import classes:
import com.alogram.v1.client.ApiClient;
import com.alogram.v1.client.ApiException;
import com.alogram.v1.client.ApiResponse;
import com.alogram.v1.client.Configuration;
import com.alogram.v1.client.auth.*;
import com.alogram.v1.client.models.*;
import com.alogram.payrisk.v1.api.PayriskApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api-dev.alogram.ai/v1");
        
        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        // Configure OAuth2 access token for authorization: oAuth2
        OAuth oAuth2 = (OAuth) defaultClient.getAuthentication("oAuth2");
        oAuth2.setAccessToken("YOUR ACCESS TOKEN");

        PayriskApi apiInstance = new PayriskApi(defaultClient);
        String xIdempotencyKey = "xIdempotencyKey_example"; // String | Unique Idempotency-Key sent in the POST request etc.
        AccountCheckRequest accountCheckRequest = new AccountCheckRequest(); // AccountCheckRequest | 
        String xTraceId = "xTraceId_example"; // String | Echoed or generated trace ID for tracking requests.
        try {
            ApiResponse<DecisionResponse> response = apiInstance.accountRiskCheckWithHttpInfo(xIdempotencyKey, accountCheckRequest, xTraceId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling PayriskApi#accountRiskCheck");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **xIdempotencyKey** | **String**| Unique Idempotency-Key sent in the POST request etc. | |
| **accountCheckRequest** | [**AccountCheckRequest**](AccountCheckRequest.md)|  | |
| **xTraceId** | **String**| Echoed or generated trace ID for tracking requests. | [optional] |

### Return type

ApiResponse<[**DecisionResponse**](DecisionResponse.md)>


### Authorization

[ApiKey](../README.md#ApiKey), [oAuth2](../README.md#oAuth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Synchronous risk decision. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **400** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **422** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **429** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **500** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |


## getFraudScores

> ScoresSuccessResponse getFraudScores(tenantId, xTraceId, xIdempotencyKey, startTime, endTime, pageSize, pageToken)

Retrieve fraud scores for a customer

### Example

```java
// Import classes:
import com.alogram.v1.client.ApiClient;
import com.alogram.v1.client.ApiException;
import com.alogram.v1.client.Configuration;
import com.alogram.v1.client.auth.*;
import com.alogram.v1.client.models.*;
import com.alogram.payrisk.v1.api.PayriskApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api-dev.alogram.ai/v1");
        
        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        // Configure OAuth2 access token for authorization: oAuth2
        OAuth oAuth2 = (OAuth) defaultClient.getAuthentication("oAuth2");
        oAuth2.setAccessToken("YOUR ACCESS TOKEN");

        PayriskApi apiInstance = new PayriskApi(defaultClient);
        String tenantId = "tenantId_example"; // String | 
        String xTraceId = "xTraceId_example"; // String | Echoed or generated trace ID for tracking requests.
        String xIdempotencyKey = "xIdempotencyKey_example"; // String | Unique Idempotency-Key sent in the GET request etc.
        String startTime = "startTime_example"; // String | 
        String endTime = "endTime_example"; // String | 
        Integer pageSize = 50; // Integer | 
        String pageToken = "pageToken_example"; // String | 
        try {
            ScoresSuccessResponse result = apiInstance.getFraudScores(tenantId, xTraceId, xIdempotencyKey, startTime, endTime, pageSize, pageToken);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PayriskApi#getFraudScores");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenantId** | **String**|  | |
| **xTraceId** | **String**| Echoed or generated trace ID for tracking requests. | [optional] |
| **xIdempotencyKey** | **String**| Unique Idempotency-Key sent in the GET request etc. | [optional] |
| **startTime** | **String**|  | [optional] |
| **endTime** | **String**|  | [optional] |
| **pageSize** | **Integer**|  | [optional] [default to 50] |
| **pageToken** | **String**|  | [optional] |

### Return type

[**ScoresSuccessResponse**](ScoresSuccessResponse.md)


### Authorization

[ApiKey](../README.md#ApiKey), [oAuth2](../README.md#oAuth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of fraud scores for a customer. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **400** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **500** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |

## getFraudScoresWithHttpInfo

> ApiResponse<ScoresSuccessResponse> getFraudScores getFraudScoresWithHttpInfo(tenantId, xTraceId, xIdempotencyKey, startTime, endTime, pageSize, pageToken)

Retrieve fraud scores for a customer

### Example

```java
// Import classes:
import com.alogram.v1.client.ApiClient;
import com.alogram.v1.client.ApiException;
import com.alogram.v1.client.ApiResponse;
import com.alogram.v1.client.Configuration;
import com.alogram.v1.client.auth.*;
import com.alogram.v1.client.models.*;
import com.alogram.payrisk.v1.api.PayriskApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api-dev.alogram.ai/v1");
        
        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        // Configure OAuth2 access token for authorization: oAuth2
        OAuth oAuth2 = (OAuth) defaultClient.getAuthentication("oAuth2");
        oAuth2.setAccessToken("YOUR ACCESS TOKEN");

        PayriskApi apiInstance = new PayriskApi(defaultClient);
        String tenantId = "tenantId_example"; // String | 
        String xTraceId = "xTraceId_example"; // String | Echoed or generated trace ID for tracking requests.
        String xIdempotencyKey = "xIdempotencyKey_example"; // String | Unique Idempotency-Key sent in the GET request etc.
        String startTime = "startTime_example"; // String | 
        String endTime = "endTime_example"; // String | 
        Integer pageSize = 50; // Integer | 
        String pageToken = "pageToken_example"; // String | 
        try {
            ApiResponse<ScoresSuccessResponse> response = apiInstance.getFraudScoresWithHttpInfo(tenantId, xTraceId, xIdempotencyKey, startTime, endTime, pageSize, pageToken);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling PayriskApi#getFraudScores");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tenantId** | **String**|  | |
| **xTraceId** | **String**| Echoed or generated trace ID for tracking requests. | [optional] |
| **xIdempotencyKey** | **String**| Unique Idempotency-Key sent in the GET request etc. | [optional] |
| **startTime** | **String**|  | [optional] |
| **endTime** | **String**|  | [optional] |
| **pageSize** | **Integer**|  | [optional] [default to 50] |
| **pageToken** | **String**|  | [optional] |

### Return type

ApiResponse<[**ScoresSuccessResponse**](ScoresSuccessResponse.md)>


### Authorization

[ApiKey](../README.md#ApiKey), [oAuth2](../README.md#oAuth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of fraud scores for a customer. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **400** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **500** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |


## healthCheck

> void healthCheck()

Health check for the service

### Example

```java
// Import classes:
import com.alogram.v1.client.ApiClient;
import com.alogram.v1.client.ApiException;
import com.alogram.v1.client.Configuration;
import com.alogram.v1.client.models.*;
import com.alogram.payrisk.v1.api.PayriskApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api-dev.alogram.ai/v1");

        PayriskApi apiInstance = new PayriskApi(defaultClient);
        try {
            apiInstance.healthCheck();
        } catch (ApiException e) {
            System.err.println("Exception when calling PayriskApi#healthCheck");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type


null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service is healthy |  -  |
| **503** | Service is unavailable |  -  |

## healthCheckWithHttpInfo

> ApiResponse<Void> healthCheck healthCheckWithHttpInfo()

Health check for the service

### Example

```java
// Import classes:
import com.alogram.v1.client.ApiClient;
import com.alogram.v1.client.ApiException;
import com.alogram.v1.client.ApiResponse;
import com.alogram.v1.client.Configuration;
import com.alogram.v1.client.models.*;
import com.alogram.payrisk.v1.api.PayriskApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api-dev.alogram.ai/v1");

        PayriskApi apiInstance = new PayriskApi(defaultClient);
        try {
            ApiResponse<Void> response = apiInstance.healthCheckWithHttpInfo();
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
        } catch (ApiException e) {
            System.err.println("Exception when calling PayriskApi#healthCheck");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type


ApiResponse<Void>

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service is healthy |  -  |
| **503** | Service is unavailable |  -  |


## ingestPaymentEvent

> void ingestPaymentEvent(xIdempotencyKey, paymentEvent, xTraceId)

Ingest payment lifecycle events (authorization, capture, settlement, refund, dispute, chargeback, chargeback_outcome). 

### Example

```java
// Import classes:
import com.alogram.v1.client.ApiClient;
import com.alogram.v1.client.ApiException;
import com.alogram.v1.client.Configuration;
import com.alogram.v1.client.auth.*;
import com.alogram.v1.client.models.*;
import com.alogram.payrisk.v1.api.PayriskApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api-dev.alogram.ai/v1");
        
        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        // Configure OAuth2 access token for authorization: oAuth2
        OAuth oAuth2 = (OAuth) defaultClient.getAuthentication("oAuth2");
        oAuth2.setAccessToken("YOUR ACCESS TOKEN");

        PayriskApi apiInstance = new PayriskApi(defaultClient);
        String xIdempotencyKey = "xIdempotencyKey_example"; // String | Unique Idempotency-Key sent in the POST request etc.
        PaymentEvent paymentEvent = new PaymentEvent(); // PaymentEvent | 
        String xTraceId = "xTraceId_example"; // String | Echoed or generated trace ID for tracking requests.
        try {
            apiInstance.ingestPaymentEvent(xIdempotencyKey, paymentEvent, xTraceId);
        } catch (ApiException e) {
            System.err.println("Exception when calling PayriskApi#ingestPaymentEvent");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **xIdempotencyKey** | **String**| Unique Idempotency-Key sent in the POST request etc. | |
| **paymentEvent** | [**PaymentEvent**](PaymentEvent.md)|  | |
| **xTraceId** | **String**| Echoed or generated trace ID for tracking requests. | [optional] |

### Return type


null (empty response body)

### Authorization

[ApiKey](../README.md#ApiKey), [oAuth2](../README.md#oAuth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Accepted |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **400** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **401** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **403** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **404** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **409** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **413** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **422** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **429** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **500** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |

## ingestPaymentEventWithHttpInfo

> ApiResponse<Void> ingestPaymentEvent ingestPaymentEventWithHttpInfo(xIdempotencyKey, paymentEvent, xTraceId)

Ingest payment lifecycle events (authorization, capture, settlement, refund, dispute, chargeback, chargeback_outcome). 

### Example

```java
// Import classes:
import com.alogram.v1.client.ApiClient;
import com.alogram.v1.client.ApiException;
import com.alogram.v1.client.ApiResponse;
import com.alogram.v1.client.Configuration;
import com.alogram.v1.client.auth.*;
import com.alogram.v1.client.models.*;
import com.alogram.payrisk.v1.api.PayriskApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api-dev.alogram.ai/v1");
        
        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        // Configure OAuth2 access token for authorization: oAuth2
        OAuth oAuth2 = (OAuth) defaultClient.getAuthentication("oAuth2");
        oAuth2.setAccessToken("YOUR ACCESS TOKEN");

        PayriskApi apiInstance = new PayriskApi(defaultClient);
        String xIdempotencyKey = "xIdempotencyKey_example"; // String | Unique Idempotency-Key sent in the POST request etc.
        PaymentEvent paymentEvent = new PaymentEvent(); // PaymentEvent | 
        String xTraceId = "xTraceId_example"; // String | Echoed or generated trace ID for tracking requests.
        try {
            ApiResponse<Void> response = apiInstance.ingestPaymentEventWithHttpInfo(xIdempotencyKey, paymentEvent, xTraceId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
        } catch (ApiException e) {
            System.err.println("Exception when calling PayriskApi#ingestPaymentEvent");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **xIdempotencyKey** | **String**| Unique Idempotency-Key sent in the POST request etc. | |
| **paymentEvent** | [**PaymentEvent**](PaymentEvent.md)|  | |
| **xTraceId** | **String**| Echoed or generated trace ID for tracking requests. | [optional] |

### Return type


ApiResponse<Void>

### Authorization

[ApiKey](../README.md#ApiKey), [oAuth2](../README.md#oAuth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Accepted |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **400** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **401** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **403** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **404** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **409** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **413** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **422** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **429** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **500** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |


## ingestSignals

> void ingestSignals(xIdempotencyKey, signalsRequest, xTraceId)

Ingest non-payment signals (account or interaction) for modeling

### Example

```java
// Import classes:
import com.alogram.v1.client.ApiClient;
import com.alogram.v1.client.ApiException;
import com.alogram.v1.client.Configuration;
import com.alogram.v1.client.auth.*;
import com.alogram.v1.client.models.*;
import com.alogram.payrisk.v1.api.PayriskApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api-dev.alogram.ai/v1");
        
        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        // Configure OAuth2 access token for authorization: oAuth2
        OAuth oAuth2 = (OAuth) defaultClient.getAuthentication("oAuth2");
        oAuth2.setAccessToken("YOUR ACCESS TOKEN");

        PayriskApi apiInstance = new PayriskApi(defaultClient);
        String xIdempotencyKey = "xIdempotencyKey_example"; // String | Unique Idempotency-Key sent in the POST request etc.
        SignalsRequest signalsRequest = new SignalsRequest(); // SignalsRequest | 
        String xTraceId = "xTraceId_example"; // String | Echoed or generated trace ID for tracking requests.
        try {
            apiInstance.ingestSignals(xIdempotencyKey, signalsRequest, xTraceId);
        } catch (ApiException e) {
            System.err.println("Exception when calling PayriskApi#ingestSignals");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **xIdempotencyKey** | **String**| Unique Idempotency-Key sent in the POST request etc. | |
| **signalsRequest** | [**SignalsRequest**](SignalsRequest.md)|  | |
| **xTraceId** | **String**| Echoed or generated trace ID for tracking requests. | [optional] |

### Return type


null (empty response body)

### Authorization

[ApiKey](../README.md#ApiKey), [oAuth2](../README.md#oAuth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Accepted |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **400** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **413** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **422** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **429** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **500** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |

## ingestSignalsWithHttpInfo

> ApiResponse<Void> ingestSignals ingestSignalsWithHttpInfo(xIdempotencyKey, signalsRequest, xTraceId)

Ingest non-payment signals (account or interaction) for modeling

### Example

```java
// Import classes:
import com.alogram.v1.client.ApiClient;
import com.alogram.v1.client.ApiException;
import com.alogram.v1.client.ApiResponse;
import com.alogram.v1.client.Configuration;
import com.alogram.v1.client.auth.*;
import com.alogram.v1.client.models.*;
import com.alogram.payrisk.v1.api.PayriskApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api-dev.alogram.ai/v1");
        
        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        // Configure OAuth2 access token for authorization: oAuth2
        OAuth oAuth2 = (OAuth) defaultClient.getAuthentication("oAuth2");
        oAuth2.setAccessToken("YOUR ACCESS TOKEN");

        PayriskApi apiInstance = new PayriskApi(defaultClient);
        String xIdempotencyKey = "xIdempotencyKey_example"; // String | Unique Idempotency-Key sent in the POST request etc.
        SignalsRequest signalsRequest = new SignalsRequest(); // SignalsRequest | 
        String xTraceId = "xTraceId_example"; // String | Echoed or generated trace ID for tracking requests.
        try {
            ApiResponse<Void> response = apiInstance.ingestSignalsWithHttpInfo(xIdempotencyKey, signalsRequest, xTraceId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
        } catch (ApiException e) {
            System.err.println("Exception when calling PayriskApi#ingestSignals");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **xIdempotencyKey** | **String**| Unique Idempotency-Key sent in the POST request etc. | |
| **signalsRequest** | [**SignalsRequest**](SignalsRequest.md)|  | |
| **xTraceId** | **String**| Echoed or generated trace ID for tracking requests. | [optional] |

### Return type


ApiResponse<Void>

### Authorization

[ApiKey](../README.md#ApiKey), [oAuth2](../README.md#oAuth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Accepted |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **400** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **413** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **422** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **429** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **500** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |


## kycRiskCheck

> DecisionResponse kycRiskCheck(xIdempotencyKey, kycCheckRequest, xTraceId)

Synchronous decision for KYC/identity verification

### Example

```java
// Import classes:
import com.alogram.v1.client.ApiClient;
import com.alogram.v1.client.ApiException;
import com.alogram.v1.client.Configuration;
import com.alogram.v1.client.auth.*;
import com.alogram.v1.client.models.*;
import com.alogram.payrisk.v1.api.PayriskApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api-dev.alogram.ai/v1");
        
        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        // Configure OAuth2 access token for authorization: oAuth2
        OAuth oAuth2 = (OAuth) defaultClient.getAuthentication("oAuth2");
        oAuth2.setAccessToken("YOUR ACCESS TOKEN");

        PayriskApi apiInstance = new PayriskApi(defaultClient);
        String xIdempotencyKey = "xIdempotencyKey_example"; // String | Unique Idempotency-Key sent in the POST request etc.
        KycCheckRequest kycCheckRequest = new KycCheckRequest(); // KycCheckRequest | 
        String xTraceId = "xTraceId_example"; // String | Echoed or generated trace ID for tracking requests.
        try {
            DecisionResponse result = apiInstance.kycRiskCheck(xIdempotencyKey, kycCheckRequest, xTraceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PayriskApi#kycRiskCheck");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **xIdempotencyKey** | **String**| Unique Idempotency-Key sent in the POST request etc. | |
| **kycCheckRequest** | [**KycCheckRequest**](KycCheckRequest.md)|  | |
| **xTraceId** | **String**| Echoed or generated trace ID for tracking requests. | [optional] |

### Return type

[**DecisionResponse**](DecisionResponse.md)


### Authorization

[ApiKey](../README.md#ApiKey), [oAuth2](../README.md#oAuth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Synchronous risk decision. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **400** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **422** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **429** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **500** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |

## kycRiskCheckWithHttpInfo

> ApiResponse<DecisionResponse> kycRiskCheck kycRiskCheckWithHttpInfo(xIdempotencyKey, kycCheckRequest, xTraceId)

Synchronous decision for KYC/identity verification

### Example

```java
// Import classes:
import com.alogram.v1.client.ApiClient;
import com.alogram.v1.client.ApiException;
import com.alogram.v1.client.ApiResponse;
import com.alogram.v1.client.Configuration;
import com.alogram.v1.client.auth.*;
import com.alogram.v1.client.models.*;
import com.alogram.payrisk.v1.api.PayriskApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api-dev.alogram.ai/v1");
        
        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        // Configure OAuth2 access token for authorization: oAuth2
        OAuth oAuth2 = (OAuth) defaultClient.getAuthentication("oAuth2");
        oAuth2.setAccessToken("YOUR ACCESS TOKEN");

        PayriskApi apiInstance = new PayriskApi(defaultClient);
        String xIdempotencyKey = "xIdempotencyKey_example"; // String | Unique Idempotency-Key sent in the POST request etc.
        KycCheckRequest kycCheckRequest = new KycCheckRequest(); // KycCheckRequest | 
        String xTraceId = "xTraceId_example"; // String | Echoed or generated trace ID for tracking requests.
        try {
            ApiResponse<DecisionResponse> response = apiInstance.kycRiskCheckWithHttpInfo(xIdempotencyKey, kycCheckRequest, xTraceId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling PayriskApi#kycRiskCheck");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **xIdempotencyKey** | **String**| Unique Idempotency-Key sent in the POST request etc. | |
| **kycCheckRequest** | [**KycCheckRequest**](KycCheckRequest.md)|  | |
| **xTraceId** | **String**| Echoed or generated trace ID for tracking requests. | [optional] |

### Return type

ApiResponse<[**DecisionResponse**](DecisionResponse.md)>


### Authorization

[ApiKey](../README.md#ApiKey), [oAuth2](../README.md#oAuth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Synchronous risk decision. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **400** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **422** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **429** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **500** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |


## riskCheck

> DecisionResponse riskCheck(xIdempotencyKey, checkRequest, xTraceId)

Synchronous fraud decision for a purchase

### Example

```java
// Import classes:
import com.alogram.v1.client.ApiClient;
import com.alogram.v1.client.ApiException;
import com.alogram.v1.client.Configuration;
import com.alogram.v1.client.auth.*;
import com.alogram.v1.client.models.*;
import com.alogram.payrisk.v1.api.PayriskApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api-dev.alogram.ai/v1");
        
        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        // Configure OAuth2 access token for authorization: oAuth2
        OAuth oAuth2 = (OAuth) defaultClient.getAuthentication("oAuth2");
        oAuth2.setAccessToken("YOUR ACCESS TOKEN");

        PayriskApi apiInstance = new PayriskApi(defaultClient);
        String xIdempotencyKey = "xIdempotencyKey_example"; // String | Unique Idempotency-Key sent in the POST request etc.
        CheckRequest checkRequest = new CheckRequest(); // CheckRequest | 
        String xTraceId = "xTraceId_example"; // String | Echoed or generated trace ID for tracking requests.
        try {
            DecisionResponse result = apiInstance.riskCheck(xIdempotencyKey, checkRequest, xTraceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PayriskApi#riskCheck");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **xIdempotencyKey** | **String**| Unique Idempotency-Key sent in the POST request etc. | |
| **checkRequest** | [**CheckRequest**](CheckRequest.md)|  | |
| **xTraceId** | **String**| Echoed or generated trace ID for tracking requests. | [optional] |

### Return type

[**DecisionResponse**](DecisionResponse.md)


### Authorization

[ApiKey](../README.md#ApiKey), [oAuth2](../README.md#oAuth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Synchronous risk decision. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **400** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **401** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **403** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **422** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **429** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **500** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |

## riskCheckWithHttpInfo

> ApiResponse<DecisionResponse> riskCheck riskCheckWithHttpInfo(xIdempotencyKey, checkRequest, xTraceId)

Synchronous fraud decision for a purchase

### Example

```java
// Import classes:
import com.alogram.v1.client.ApiClient;
import com.alogram.v1.client.ApiException;
import com.alogram.v1.client.ApiResponse;
import com.alogram.v1.client.Configuration;
import com.alogram.v1.client.auth.*;
import com.alogram.v1.client.models.*;
import com.alogram.payrisk.v1.api.PayriskApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api-dev.alogram.ai/v1");
        
        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        // Configure OAuth2 access token for authorization: oAuth2
        OAuth oAuth2 = (OAuth) defaultClient.getAuthentication("oAuth2");
        oAuth2.setAccessToken("YOUR ACCESS TOKEN");

        PayriskApi apiInstance = new PayriskApi(defaultClient);
        String xIdempotencyKey = "xIdempotencyKey_example"; // String | Unique Idempotency-Key sent in the POST request etc.
        CheckRequest checkRequest = new CheckRequest(); // CheckRequest | 
        String xTraceId = "xTraceId_example"; // String | Echoed or generated trace ID for tracking requests.
        try {
            ApiResponse<DecisionResponse> response = apiInstance.riskCheckWithHttpInfo(xIdempotencyKey, checkRequest, xTraceId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling PayriskApi#riskCheck");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **xIdempotencyKey** | **String**| Unique Idempotency-Key sent in the POST request etc. | |
| **checkRequest** | [**CheckRequest**](CheckRequest.md)|  | |
| **xTraceId** | **String**| Echoed or generated trace ID for tracking requests. | [optional] |

### Return type

ApiResponse<[**DecisionResponse**](DecisionResponse.md)>


### Authorization

[ApiKey](../README.md#ApiKey), [oAuth2](../README.md#oAuth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Synchronous risk decision. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **400** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **401** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **403** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **422** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **429** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
| **500** | An error response. |  * x-trace-id -  <br>  * x-idempotency-key -  <br>  |
