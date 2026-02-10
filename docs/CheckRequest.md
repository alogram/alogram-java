

# CheckRequest

Request for synchronous purchase risk check.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**eventType** | [**EventTypeEnum**](#EventTypeEnum) | (optional) event being checked, this may expand later beyond &#39;purchase&#39;. |  [optional] |
|**paymentIntentId** | **String** | Server-minted unique payment identifier. |  [optional] |
|**entities** | [**EntityIds**](EntityIds.md) |  |  |
|**purchase** | [**Purchase**](Purchase.md) |  |  |
|**identity** | [**Identity**](Identity.md) |  |  [optional] |



## Enum: EventTypeEnum

| Name | Value |
|---- | -----|
| PURCHASE | &quot;purchase&quot; |
