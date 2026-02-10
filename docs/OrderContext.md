

# OrderContext

Order context for the purchase.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**orderId** | **String** | Unique identifier for the order. |  [optional] |
|**orderTotal** | **Float** | Value of the purchase in the specified currency. Must be a positive number with up to two decimal places.  |  [optional] |
|**shippingMethod** | [**ShippingMethodEnum**](#ShippingMethodEnum) | Shipping method for the order. |  [optional] |
|**lineItemCount** | **Integer** | Number of items in the order. |  [optional] |



## Enum: ShippingMethodEnum

| Name | Value |
|---- | -----|
| DIGITAL | &quot;digital&quot; |
| SHIP | &quot;ship&quot; |
| BOPIS | &quot;bopis&quot; |
