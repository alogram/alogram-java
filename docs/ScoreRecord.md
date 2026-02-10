

# ScoreRecord

Fraud score for a specific transaction or entity.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**assessmentId** | **String** | Universal decision identifier (for purchases, equals paymentIntentId). |  |
|**paymentIntentId** | **String** | Server-minted unique payment identifier. |  [optional] |
|**decisionAt** | **String** | RFC 3339 timestamp with timezone. |  |
|**decision** | [**DecisionEnum**](#DecisionEnum) | The synchronous risk decision for a purchase. |  |
|**riskScore** | **Float** | Fraud risk score (0.00 - 1.00). |  |
|**fraudScore** | [**FraudScore**](FraudScore.md) |  |  [optional] |
|**breakdown** | [**RiskBreakdown**](RiskBreakdown.md) |  |  [optional] |
|**reasons** | [**List&lt;ReasonDetail&gt;**](ReasonDetail.md) | Structured reason details for the score. |  [optional] |
|**entities** | [**EntityIds**](EntityIds.md) |  |  [optional] |
|**amount** | **Float** | Value of the purchase in the specified currency. Must be a positive number with up to two decimal places.  |  [optional] |
|**currency** | **String** | ISO 4217 currency code (e.g., &#39;USD&#39;). |  [optional] |



## Enum: DecisionEnum

| Name | Value |
|---- | -----|
| APPROVE | &quot;approve&quot; |
| REVIEW | &quot;review&quot; |
| DECLINE | &quot;decline&quot; |
| STEP_UP | &quot;step_up&quot; |
