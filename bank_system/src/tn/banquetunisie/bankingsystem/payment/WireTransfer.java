package tn.banquetunisie.bankingsystem.payment;

public class WireTransfer implements PaymentMethod {

    @Override
    public void processPayment(double amount) {
        System.out.println("Transferred $" + amount + " via Wire Transfer.");
    }
}