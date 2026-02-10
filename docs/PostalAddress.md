

# PostalAddress

Postal address used for shipping or billing. Raw values are used only for normalization and risk signals; Alogram will not persist raw address fields in long-term storage. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**line1** | **String** | First line of the street address. |  [optional] |
|**line2** | **String** | Second line of the street address (apartment, suite, etc.). |  [optional] |
|**city** | **String** | City or locality. |  [optional] |
|**region** | **String** | State, province, or region. |  [optional] |
|**postalCode** | **String** | Postal / ZIP code. |  [optional] |
|**country** | **String** | ISO 3166-1 alpha-2 country code. |  [optional] |
