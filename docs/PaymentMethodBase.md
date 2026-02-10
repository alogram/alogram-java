

# PaymentMethodBase

Common base for all payment method variants; determined by `type`.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | The payment instrument type for this purchase. |  |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| CARD | &quot;card&quot; |
| WALLET | &quot;wallet&quot; |
| REALTIME | &quot;realtime&quot; |
| BANK_TRANSFER | &quot;bank_transfer&quot; |
| CRYPTO | &quot;crypto&quot; |
| INVOICE | &quot;invoice&quot; |
