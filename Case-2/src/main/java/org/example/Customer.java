package org.example;

public class Customer {
    private String name;
    private String sector;

    public Customer(String name, String sector) {
        this.name = name;
        this.sector = sector;
    }

    public String getName() {
        return name;
    }

    public String getSector() {
        return sector;
    }
}
