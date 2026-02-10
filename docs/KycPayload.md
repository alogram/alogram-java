

# KycPayload

KYC provider result payload.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**provider** | **String** |  |  [optional] |
|**documentType** | [**DocumentTypeEnum**](#DocumentTypeEnum) | The document type used for verification. |  [optional] |
|**country** | **String** |  |  [optional] |
|**result** | [**ResultEnum**](#ResultEnum) | The result of the KYC check. |  [optional] |
|**reasonCodes** | **List&lt;String&gt;** | Array of reason codes for the KYC check. |  [optional] |
|**metadata** | **String** | Optional key-value pairs providing additional context for the request.  Each key should be descriptive, and values should not exceed 2048 characters.  Each key should be descriptive.  |  [optional] |



## Enum: DocumentTypeEnum

| Name | Value |
|---- | -----|
| PASSPORT | &quot;passport&quot; |
| NATIONAL_ID | &quot;national_id&quot; |
| DRIVER_LICENSE | &quot;driver_license&quot; |
| OTHER | &quot;other&quot; |



## Enum: ResultEnum

| Name | Value |
|---- | -----|
| PASSED | &quot;passed&quot; |
| FAILED | &quot;failed&quot; |
| REVIEW | &quot;review&quot; |
| TIMEOUT | &quot;timeout&quot; |
| ERROR | &quot;error&quot; |
