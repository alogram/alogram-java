

# SignalsRequest

Request for processing application workflow signals. Determined by `signalType`. 

## oneOf schemas
* [SignalsAccountVariant](SignalsAccountVariant.md)
* [SignalsInteractionVariant](SignalsInteractionVariant.md)

## Example
```java
// Import classes:
import com.alogram.payrisk.v1.models.SignalsRequest;
import com.alogram.payrisk.v1.models.SignalsAccountVariant;
import com.alogram.payrisk.v1.models.SignalsInteractionVariant;

public class Example {
    public static void main(String[] args) {
        SignalsRequest exampleSignalsRequest = new SignalsRequest();

        // create a new SignalsAccountVariant
        SignalsAccountVariant exampleSignalsAccountVariant = new SignalsAccountVariant();
        // set SignalsRequest to SignalsAccountVariant
        exampleSignalsRequest.setActualInstance(exampleSignalsAccountVariant);
        // to get back the SignalsAccountVariant set earlier
        SignalsAccountVariant testSignalsAccountVariant = (SignalsAccountVariant) exampleSignalsRequest.getActualInstance();

        // create a new SignalsInteractionVariant
        SignalsInteractionVariant exampleSignalsInteractionVariant = new SignalsInteractionVariant();
        // set SignalsRequest to SignalsInteractionVariant
        exampleSignalsRequest.setActualInstance(exampleSignalsInteractionVariant);
        // to get back the SignalsInteractionVariant set earlier
        SignalsInteractionVariant testSignalsInteractionVariant = (SignalsInteractionVariant) exampleSignalsRequest.getActualInstance();
    }
}
```
