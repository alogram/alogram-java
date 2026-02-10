

# Identity

Optional raw identity details for the account associated with the purchase. These fields (email, phone, addresses) are used for normalization, hashing, and risk feature extraction (e.g., email/phone/domain scoring, address risk), and are not stored in raw form by Alogram.  When provided, Alogram will derive and/or cross-check: - emailHash / phoneHash / shippingAddressHash / billingAddressHash   in the internal entity model - email/phone/domain risk signals - address consistency and geo-distance checks 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**email** | **String** | Email address of the customer. |  [optional] |
|**emailDomain** | **String** | Email domain only (no local part). Useful for domain-level risk and allow/deny lists without sending full email PII. Example: \&quot;gmail.com\&quot;, \&quot;merchant-example.co.uk\&quot;  |  [optional] |
|**phone** | **String** | Phone number that supports international E.164 format, as well as spaces, dashes, and parentheses.  Examples: \&quot;+1 (415) 555-2671\&quot;, \&quot;415-555-2671\&quot;, \&quot;+14155552671\&quot;  |  [optional] |
|**shippingAddress** | [**PostalAddress**](PostalAddress.md) |  |  [optional] |
|**billingAddress** | [**PostalAddress**](PostalAddress.md) |  |  [optional] |
