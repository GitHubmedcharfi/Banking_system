package tn.banquetunisie.bankingsystem.payment;

public class CreditCard implements PaymentMethod {
    private String cardNumber;
    private double limit;

    public CreditCard(String cardNumber, double limit) {
        this.cardNumber = cardNumber;
        this.limit = limit;
    }

    @Override
    public void processPayment(double amount) {
        if (amount <= limit) {
            limit -= amount;
            System.out.println("Paid $" + amount + " using Credit Card " + cardNumber);
        } else {
            System.out.println("Credit limit exceeded!");
        }
    }
}
