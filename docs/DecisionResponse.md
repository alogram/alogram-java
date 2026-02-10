

# DecisionResponse

The synchronous risk decision for a purchase.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**assessmentId** | **String** | Universal decision identifier. For purchases, equals paymentIntentId. |  |
|**decision** | [**DecisionEnum**](#DecisionEnum) |  |  |
|**decisionAt** | **String** | RFC 3339 timestamp with timezone. |  |
|**riskScore** | **Float** |  |  |
|**fraudScore** | [**FraudScore**](FraudScore.md) |  |  [optional] |
|**breakdown** | [**RiskBreakdown**](RiskBreakdown.md) |  |  [optional] |
|**reasonCodes** | **List&lt;String&gt;** | Technical reason codes for the decision. |  [optional] |
|**reasons** | [**List&lt;ReasonDetail&gt;**](ReasonDetail.md) | Structured reason details for the decision. |  [optional] |
|**actions** | [**List&lt;ActionsEnum&gt;**](#List&lt;ActionsEnum&gt;) |  |  [optional] |
|**paymentIntentId** | **String** | Server-minted unique payment identifier. |  [optional] |
|**policyVersion** | **String** | The version of the policy that generated the decision. |  [optional] |
|**modelVersion** | **String** | The version of the model that generated the decision. |  [optional] |
|**ttlSeconds** | **Integer** | Time to live for the decision in seconds. |  [optional] |



## Enum: DecisionEnum

| Name | Value |
|---- | -----|
| APPROVE | &quot;approve&quot; |
| REVIEW | &quot;review&quot; |
| DECLINE | &quot;decline&quot; |
| STEP_UP | &quot;step_up&quot; |



## Enum: List&lt;ActionsEnum&gt;

| Name | Value |
|---- | -----|
| STEP_UP | &quot;step_up&quot; |
| THROTTLE | &quot;throttle&quot; |
| LOCK_ACCOUNT | &quot;lock_account&quot; |
| DECLINE | &quot;decline&quot; |
| QUEUE_REVIEW | &quot;queue_review&quot; |
