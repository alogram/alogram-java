

# PaymentOutcome

Payment outcome details. Structured by lifecycle stage for clarity and validation. Stages include authorization, capture, refund, dispute, chargeback, and chargebackOutcome. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**authorization** | [**PaymentAuthorizationOutcome**](PaymentAuthorizationOutcome.md) |  |  [optional] |
|**capture** | [**PaymentCaptureOutcome**](PaymentCaptureOutcome.md) |  |  [optional] |
|**refund** | [**PaymentRefundOutcome**](PaymentRefundOutcome.md) |  |  [optional] |
|**dispute** | [**PaymentDisputeOutcome**](PaymentDisputeOutcome.md) |  |  [optional] |
|**chargeback** | [**PaymentChargeback**](PaymentChargeback.md) |  |  [optional] |
|**chargebackOutcome** | [**PaymentChargebackOutcome**](PaymentChargebackOutcome.md) |  |  [optional] |
