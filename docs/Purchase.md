

# Purchase

Purchase details for fraud checks; core fields are common, instrument specifics live in `paymentMethod`. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**locationId** | **String** | Unique identifier for the location where the transaction occurred. |  [optional] |
|**deviceInfo** | [**DeviceInfo**](DeviceInfo.md) |  |  [optional] |
|**timestamp** | **String** | RFC 3339 timestamp with timezone. |  [optional] |
|**transactionId** | **String** | A unique identifier for the transaction. Must be between 3 and 50 characters and only contain alphanumeric characters, underscores, or hyphens.  |  [optional] |
|**amount** | **Float** | Value of the purchase in the specified currency. Must be a positive number with up to two decimal places.  |  |
|**currency** | **String** | ISO 4217 currency code (e.g., &#39;USD&#39;). |  |
|**channel** | **ChannelEnum** |  |  [optional] |
|**entryMethod** | **EntryMethodEnum** |  |  [optional] |
|**paymentMethod** | [**PaymentMethod**](PaymentMethod.md) |  |  |
|**order** | [**OrderContext**](OrderContext.md) |  |  [optional] |
|**payerType** | **PayerTypeEnum** |  |  [optional] |
|**storedCredential** | [**StoredCredentialContext**](StoredCredentialContext.md) |  |  [optional] |
|**merchant** | [**MerchantContext**](MerchantContext.md) |  |  [optional] |
|**metadata** | **String** | Optional key-value pairs providing additional context for the request.  Each key should be descriptive, and values should not exceed 2048 characters.  Each key should be descriptive.  |  [optional] |
