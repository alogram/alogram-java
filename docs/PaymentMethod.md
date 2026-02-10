

# PaymentMethod

Union of instrument-specific payment details.

## oneOf schemas
* [BankTransfer](BankTransfer.md)
* [Card](Card.md)
* [Crypto](Crypto.md)
* [Invoice](Invoice.md)
* [Realtime](Realtime.md)
* [Wallet](Wallet.md)

## Example
```java
// Import classes:
import com.alogram.payrisk.v1.models.PaymentMethod;
import com.alogram.payrisk.v1.models.BankTransfer;
import com.alogram.payrisk.v1.models.Card;
import com.alogram.payrisk.v1.models.Crypto;
import com.alogram.payrisk.v1.models.Invoice;
import com.alogram.payrisk.v1.models.Realtime;
import com.alogram.payrisk.v1.models.Wallet;

public class Example {
    public static void main(String[] args) {
        PaymentMethod examplePaymentMethod = new PaymentMethod();

        // create a new BankTransfer
        BankTransfer exampleBankTransfer = new BankTransfer();
        // set PaymentMethod to BankTransfer
        examplePaymentMethod.setActualInstance(exampleBankTransfer);
        // to get back the BankTransfer set earlier
        BankTransfer testBankTransfer = (BankTransfer) examplePaymentMethod.getActualInstance();

        // create a new Card
        Card exampleCard = new Card();
        // set PaymentMethod to Card
        examplePaymentMethod.setActualInstance(exampleCard);
        // to get back the Card set earlier
        Card testCard = (Card) examplePaymentMethod.getActualInstance();

        // create a new Crypto
        Crypto exampleCrypto = new Crypto();
        // set PaymentMethod to Crypto
        examplePaymentMethod.setActualInstance(exampleCrypto);
        // to get back the Crypto set earlier
        Crypto testCrypto = (Crypto) examplePaymentMethod.getActualInstance();

        // create a new Invoice
        Invoice exampleInvoice = new Invoice();
        // set PaymentMethod to Invoice
        examplePaymentMethod.setActualInstance(exampleInvoice);
        // to get back the Invoice set earlier
        Invoice testInvoice = (Invoice) examplePaymentMethod.getActualInstance();

        // create a new Realtime
        Realtime exampleRealtime = new Realtime();
        // set PaymentMethod to Realtime
        examplePaymentMethod.setActualInstance(exampleRealtime);
        // to get back the Realtime set earlier
        Realtime testRealtime = (Realtime) examplePaymentMethod.getActualInstance();

        // create a new Wallet
        Wallet exampleWallet = new Wallet();
        // set PaymentMethod to Wallet
        examplePaymentMethod.setActualInstance(exampleWallet);
        // to get back the Wallet set earlier
        Wallet testWallet = (Wallet) examplePaymentMethod.getActualInstance();
    }
}
```
