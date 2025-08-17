package parkinglot;

public class CashStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with cash");
    }
}
