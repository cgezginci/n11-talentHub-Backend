package org.example;

import java.time.Month;

public class Invoice {
    private Customer customer;
    private double amount;
    private Month month;

    public Invoice(Customer customer, double amount, Month month) {
        this.customer = customer;
        this.amount = amount;
        this.month = month;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    public Month getMonth() {
        return month;
    }
}
