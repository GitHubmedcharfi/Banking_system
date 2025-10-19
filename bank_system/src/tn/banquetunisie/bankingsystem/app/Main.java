package tn.banquetunisie.bankingsystem.app;

import tn.banquetunisie.bankingsystem.model.Account;
import tn.banquetunisie.bankingsystem.model.Bank;
import tn.banquetunisie.bankingsystem.model.Customer;
import tn.banquetunisie.bankingsystem.model.Transaction;
import tn.banquetunisie.bankingsystem.payment.CreditCard;
import tn.banquetunisie.bankingsystem.payment.PaymentMethod;
import tn.banquetunisie.bankingsystem.payment.WireTransfer;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Banque Tunisie");

        Customer c1 = new Customer(1, "Mohamed Charfi", "m.charfi@example.com");
        Customer c2 = new Customer(2, "Sara Ben Ali", "s.benali@example.com");

        bank.addCustomer(c1);
        bank.addCustomer(c2);

        Account savings = bank.openAccount(c1, "savings");
        Account checking = bank.openAccount(c2, "checking");

        savings.deposit(1500);
        savings.withdraw(200);
        checking.deposit(1000);
        checking.withdraw(300);

        Transaction t1 = new Transaction("Deposit", 1500, savings);
        Transaction t2 = new Transaction("Withdrawal", 200, savings);
        t1.execute();
        t2.execute();

        PaymentMethod creditCard = new CreditCard("1234-5678-9876-5432", 5000.0);
        PaymentMethod wireTransfer = new WireTransfer();

        creditCard.processPayment(250);
        wireTransfer.processPayment(400);

        System.out.println("\nTotal bank balance: $" + bank.getTotalBalance());
    }
}
