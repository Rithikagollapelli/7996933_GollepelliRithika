// StrategyPatternExample.java

// Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategy - Credit Card
class CreditCardPayment implements PaymentStrategy {

    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount +
                " using Credit Card (" + cardNumber + ")");
    }
}

// Concrete Strategy - PayPal
class PayPalPayment implements PaymentStrategy {

    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount +
                " using PayPal (" + email + ")");
    }
}

// Context Class
class PaymentContext {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Main Class
public class Exe8StrategyPatternExample {

    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        // Credit Card Payment
        context.setPaymentStrategy(
                new CreditCardPayment("1234-5678-9012"));
        context.makePayment(5000);

        // PayPal Payment
        context.setPaymentStrategy(
                new PayPalPayment("rithikagollapell@gmail.com"));
        context.makePayment(2500);
    }
}