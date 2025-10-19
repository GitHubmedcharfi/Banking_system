package tn.banquetunisie.bankingsystem.model;

import java.util.Date;

public class Transaction {
    private static int counter = 0;
    private int id;
    private Date date;
    private String type;
    private double amount;
    private Account account;

    // Constructor
    public Transaction(String type, double amount, Account account) {
        this.id = ++counter;
        this.date = new Date();
        this.type = type;
        this.amount = amount;
        this.account = account;
    }

    // Method
    public void execute() {
        System.out.println(type + " of $" + amount + " executed on account " + account.getAccountNumber());
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}