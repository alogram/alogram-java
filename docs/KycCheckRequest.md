

# KycCheckRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**eventSubtype** | [**EventSubtypeEnum**](#EventSubtypeEnum) | The specific subtype of the KYC event. |  |
|**entities** | [**EntityIds**](EntityIds.md) |  |  [optional] |
|**account** | [**Account**](Account.md) |  |  |
|**kyc** | [**KycPayload**](KycPayload.md) |  |  [optional] |



## Enum: EventSubtypeEnum

| Name | Value |
|---- | -----|
| PRE_KYC_CHECK | &quot;pre_kyc_check&quot; |
| DOC_SCAN | &quot;doc_scan&quot; |
| LIVENESS | &quot;liveness&quot; |
| ADDRESS_CHECK | &quot;address_check&quot; |
| SANCTIONS_PEP | &quot;sanctions_pep&quot; |
