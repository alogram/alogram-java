

# PaymentEvent

Payment lifecycle event.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**paymentIntentId** | **String** | Server-minted unique payment identifier. |  |
|**eventType** | **PaymentEventType** |  |  |
|**timestamp** | **String** | RFC 3339 timestamp with timezone. |  |
|**amount** | **Float** | Value of the purchase in the specified currency. Must be a positive number with up to two decimal places.  |  [optional] |
|**currency** | **String** | ISO 4217 currency code (e.g., &#39;USD&#39;). |  [optional] |
|**outcome** | **PaymentOutcome** |  |  [optional] |
|**metadata** | **String** | Optional key-value pairs providing additional context for the request.  Each key should be descriptive, and values should not exceed 2048 characters.  Each key should be descriptive.  |  [optional] |
