

# AccountCheckRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**eventSubtype** | [**EventSubtypeEnum**](#EventSubtypeEnum) | The specific subtype of the account event (e.g., &#39;signup&#39;, &#39;login&#39;). |  |
|**entities** | [**EntityIds**](EntityIds.md) |  |  [optional] |
|**account** | [**Account**](Account.md) |  |  [optional] |
|**interaction** | [**Interaction**](Interaction.md) |  |  [optional] |



## Enum: EventSubtypeEnum

| Name | Value |
|---- | -----|
| SIGNUP | &quot;signup&quot; |
| LOGIN | &quot;login&quot; |
| PASSWORD_RESET | &quot;password_reset&quot; |
| MFA_RESET | &quot;mfa_reset&quot; |
| SETTING_CHANGE | &quot;setting_change&quot; |
