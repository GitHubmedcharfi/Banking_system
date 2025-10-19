package tn.banquetunisie.bankingsystem.model;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, Customer owner, double interestRate) {
        super(accountNumber, owner);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = balance * interestRate;
        deposit(interest);
    }

    @Override
    public void displayAccountType() {
        System.out.println("Savings Account");
    }
}
