

# ThreeDSData

3D Secure (3DS) data for card transactions.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**version** | **String** | The version of the 3D Secure protocol used (e.g., &#39;2.2.0&#39;). |  [optional] |
|**eci** | **String** | Electronic Commerce Indicator. Values indicate the outcome of 3D Secure authentication.  |  [optional] |
|**flow** | [**FlowEnum**](#FlowEnum) | The flow of the 3D Secure authentication. &#39;frictionless&#39; means no challenge was presented to the cardholder, &#39;challenge&#39; means the cardholder was challenged.  |  [optional] |
|**liabilityShift** | **Boolean** | Indicates whether liability for chargebacks has shifted to the issuer (true) or remains with the merchant (false).  |  [optional] |
|**cavvPresent** | **Boolean** | Indicates whether the Cardholder Authentication Verification Value (CAVV) was present in the 3DS message.  |  [optional] |



## Enum: FlowEnum

| Name | Value |
|---- | -----|
| FRICTIONLESS | &quot;frictionless&quot; |
| CHALLENGE | &quot;challenge&quot; |
