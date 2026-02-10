

# Card


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | Fixed to &#x60;card&#x60; for this schema. |  |
|**cardNetwork** | **CardNetworkEnum** |  |  [optional] |
|**cardType** | **PaymentCardTypeEnum** |  |  [optional] |
|**bin** | **String** | Bank Identification Number (IIN). First 6–8 digits of the PAN; do not send full PAN. |  [optional] |
|**issuerCountry** | **String** | ISO 3166-1 alpha-2 country code. |  [optional] |
|**avsResult** | **AvsResultEnum** |  |  [optional] |
|**cvvResult** | **CvvResultEnum** |  |  [optional] |
|**scaMethod** | **ScaMethodEnum** |  |  [optional] |
|**threeDS** | [**ThreeDSData**](ThreeDSData.md) |  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| CARD | &quot;card&quot; |
