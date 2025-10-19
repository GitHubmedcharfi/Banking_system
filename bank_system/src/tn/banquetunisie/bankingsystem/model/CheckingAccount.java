package tn.banquetunisie.bankingsystem.model;

public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, Customer owner, double overdraftLimit) {
        super(accountNumber, owner);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            getTransactions().add(new Transaction("Withdraw", amount, this));
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }

    @Override
    public void displayAccountType() {
        System.out.println("Checking Account");
    }
}
