package parkinglot;

public class CreditCardStrategy implements PaymentStrategy {
    private String cardHolderName;
    private String cardNumber;
    private String cvv;
    private String dateOfExiry;

    public CreditCardStrategy(String cardHolderName, String cardNumber, String cvv, String dateOfExiry) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExiry = dateOfExiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit card");
    }
}
