

# IpInfo


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**ipAddress** | **String** | IP address of the customer, client, or user that initiated the request. Each octet must be between 0 and 255.  |  [optional] |
|**ipv6** | **String** | IPv6 address. |  [optional] |
|**ipVersion** | [**IpVersionEnum**](#IpVersionEnum) | IP protocol version. |  [optional] |
|**ipPrefix** | **String** | CIDR, e.g., 198.51.100.0/24 or 2001:db8::/48 |  [optional] |
|**asn** | **String** | Autonomous System Number (ASN) of the IP address. |  [optional] |
|**org** | **String** | Organization associated with the IP address. |  [optional] |
|**company** | **String** | Company associated with the IP address. |  [optional] |
|**country** | **String** | ISO 3166-1 alpha-2 country code. |  [optional] |
|**region** | **String** | Region associated with the IP address. |  [optional] |
|**city** | **String** | City associated with the IP address. |  [optional] |
|**postalCode** | **String** | Postal code associated with the IP address. |  [optional] |



## Enum: IpVersionEnum

| Name | Value |
|---- | -----|
| IPV4 | &quot;ipv4&quot; |
| IPV6 | &quot;ipv6&quot; |
