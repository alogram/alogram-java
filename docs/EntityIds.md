

# EntityIds

Canonical entity identifiers (tenant/client/user/device/session). Do not send raw PII. Hash emails/phones/addresses as sha256 and prefix with 'sha256_'. Tiered support:   - tenantId is the top-level SaaS customer (required for all flows).   - clientId is the tenant’s downstream business customer (e.g. merchant/partner) and MAY be omitted for     processor / bank / PSP-style integrations.   - endCustomerId is the tenant/client’s consumer or business account (cardholder, shopper, etc.) and     MAY be omitted for purely device- or instrument-level checks. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**tenantId** | **String** | Canonical ID for the paying organization (Tenant). Opaque, immutable, lowercase.  Must start with \&quot;tid_\&quot;. Do not use domains or emails here. For a tenant&#39;s domain,  use a separate field (e.g., tenantDomain).  |  [optional] |
|**clientId** | **String** | Canonical ID for the Tenant’s business customer (e.g., merchant/partner).  Opaque, immutable, lowercase. Must start with &#39;cid_&#39;.  |  [optional] |
|**endCustomerId** | **String** | Canonical ID for the client’s end user / consumer (account holder).  Opaque, immutable, lowercase. Must start with \&quot;ecid_\&quot;.  Do not put PII (like emails or phone numbers) in this field.  |  [optional] |
|**memberId** | **String** | Canonical ID for a Tenant member/operator (employee/contractor) using the platform.  Opaque, immutable, lowercase. Must start with &#39;mid_&#39;.  |  [optional] |
|**paymentInstrumentId** | **String** | Tokenized instrument ID (non-PCI). |  [optional] |
|**deviceId** | **String** | Server-issued stable device token (device-level identifier). Should persist across sessions and logins on the same browser/device.  |  [optional] |
|**sessionId** | **String** | Application/user session identifier (login or checkout session). Typically rotates more frequently than deviceId and may be tied to authentication.  |  [optional] |
|**emailHash** | **String** | Normalized+lowercased email hash (e.g., sha256). |  [optional] |
|**emailDomainHash** | **String** | Normalized+lowercased email *domain* hash (e.g., sha256). |  [optional] |
|**phoneHash** | **String** | Normalized+lowercased phone hash (e.g., sha256). |  [optional] |
|**shippingAddressHash** | **String** | Normalized+lowercased shipping address hash (e.g., sha256). |  [optional] |
|**billingAddressHash** | **String** | Normalized+lowercased billing address hash (e.g., sha256). |  [optional] |
