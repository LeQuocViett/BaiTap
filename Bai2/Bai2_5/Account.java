package Bai2_5;

import java.util.Arrays;

public class Account {
    private int id;
    private Customer customer;
    private double balance = 0.0;

    public Account(int id, Customer customer, double balance) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }

    public Account(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getCustomerName() {
        return this.customer.getName();
    }
    public Account deposit(double amount) {
        this.balance+=amount;
        return this;
    }
    public Account withdraw(double amount) {
        if (amount > balance) {
            System.out.println("khoong du so du.");
        } else {
                this.balance -= amount;
            }
        return this;
    }

    @Override
    public String toString() {
        return this.customer.getName() + "(" + this.id + ") " +
                ", balance=" + String.format("$%.2f", this.balance) +
                '}';
    }
}
