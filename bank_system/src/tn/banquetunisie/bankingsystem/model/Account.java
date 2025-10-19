package tn.banquetunisie.bankingsystem.model;

import java.util.ArrayList;
import java.util.List;

import tn.banquetunisie.bankingsystem.model.Transaction;
public abstract class Account {
    private String accountNumber;   
    protected double balance;
    private Customer owner;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(String accountNumber, Customer owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount, this));
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount, this));
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getOwner() {
        return owner;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public abstract void displayAccountType();
}
