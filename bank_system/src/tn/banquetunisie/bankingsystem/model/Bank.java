package tn.banquetunisie.bankingsystem.model;
import tn.banquetunisie.bankingsystem.model.Customer;
import tn.banquetunisie.bankingsystem.model.Account;
import java.util.ArrayList;
import java.util.List;
public class Bank {
    private String name;
    private List<Customer> customers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Account openAccount(Customer customer, String type) {
        Account account;
        if (type.equalsIgnoreCase("savings")) {
            account = new SavingsAccount("S-" + (accounts.size() + 1), customer, 0.03);
        } else {
            account = new CheckingAccount("C-" + (accounts.size() + 1), customer, 500.0);
        }
        accounts.add(account);
        customer.addAccount(account);
        return account;
    }

    public double getTotalBalance() {
        return accounts.stream().mapToDouble(Account::getBalance).sum();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}