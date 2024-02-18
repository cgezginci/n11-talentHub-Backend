package org.example;

import java.time.Month;
import java.util.*;


public class App 
{

    private List<Customer> customers;
    private List<Invoice> invoices;

    public App() {
        customers = new ArrayList<>();
        invoices = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public List<Customer> getAllCustomers() {
        return Collections.unmodifiableList(customers);
    }

    public List<Invoice> getAllInvoices() {
        return Collections.unmodifiableList(invoices);
    }

    public List<Customer> getCustomersWithNameContainingC() {
        List<Customer> filteredCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().toLowerCase().contains("c")) {
                filteredCustomers.add(customer);
            }
        }
        return filteredCustomers;
    }

    public double getTotalAmountOfInvoicesInMonth(Month month) {
        double totalAmount = 0.0;
        for (Invoice invoice : invoices) {
            if (invoice.getMonth() == month) {
                totalAmount += invoice.getAmount();
            }
        }
        return totalAmount;
    }

    public List<Invoice> getInvoicesAboveThreshold(double threshold) {
        List<Invoice> filteredInvoices = new ArrayList<>();
        for (Invoice invoice : invoices) {
            if (invoice.getAmount() > threshold) {
                filteredInvoices.add(invoice);
            }
        }
        return filteredInvoices;
    }

    public double getAverageAmountOfInvoicesAboveThreshold(double threshold) {
        List<Invoice> filteredInvoices = getInvoicesAboveThreshold(threshold);
        double totalAmount = 0.0;
        for (Invoice invoice : filteredInvoices) {
            totalAmount += invoice.getAmount();
        }
        return totalAmount / filteredInvoices.size();
    }

    public List<String> getCustomersWithInvoicesBelowThreshold(double threshold) {
        List<String> filteredCustomers = new ArrayList<>();
        for (Invoice invoice : invoices) {
            if (invoice.getAmount() < threshold) {
                filteredCustomers.add(invoice.getCustomer().getName());
            }
        }
        return filteredCustomers;
    }



    public List<String> getSectorsWithAvgInvoiceBelowThresholdInJune(Month month, double threshold) {
        List<String> filteredCustomerSectors = new ArrayList<>();
        Map<String, Double> sectorTotalAmountMap = new HashMap<>();
        Map<String, Integer> sectorInvoiceCountMap = new HashMap<>();

        for (Invoice invoice : invoices) {
            if (invoice.getMonth() == month) {
                String sector = invoice.getCustomer().getSector();
                double amount = invoice.getAmount();

                sectorTotalAmountMap.put(sector, sectorTotalAmountMap.getOrDefault(sector, 0.0) + amount);
                sectorInvoiceCountMap.put(sector, sectorInvoiceCountMap.getOrDefault(sector, 0) + 1);
            }
        }

        for (Map.Entry<String, Double> entry : sectorTotalAmountMap.entrySet()) {
            String sector = entry.getKey();
            double totalAmount = entry.getValue();
            int invoiceCount = sectorInvoiceCountMap.get(sector);
            double averageAmount = totalAmount / invoiceCount;

            if (averageAmount < threshold) {
                filteredCustomerSectors.add(sector);
            }
        }

        return filteredCustomerSectors;
    }

    public static void main( String[] args )
    {
        App app = new App();
        Customer customer1 = new Customer("ABC Co.", "Technology");
        Customer customer2 = new Customer("DEF Inc.", "Healthcare");
        Customer customer3 = new Customer("GHI Ltd. ", "Retail");
        app.addCustomer(customer1);
        app.addCustomer(customer2);
        app.addCustomer(customer3);

        Invoice invoice1 = new Invoice(customer1, 400.0, Month.JUNE);
        Invoice invoice2 = new Invoice(customer2, 1800.0, Month.JUNE);
        Invoice invoice3 = new Invoice(customer3, 600.0, Month.JUNE);
        Invoice invoice4 = new Invoice(customer1, 1600.0, Month.JULY);
        app.addInvoice(invoice1);
        app.addInvoice(invoice2);
        app.addInvoice(invoice3);
        app.addInvoice(invoice4);

        // Tüm müşterileri listeleme
        System.out.println("Tüm Müşteriler:");
        for (Customer customer : app.getAllCustomers()) {
            System.out.println(customer.getName());
        }
        System.out.println();

        // 'C' harfi içeren müşterileri listeleme
        System.out.println("İçinde 'C' Harfi Bulunan Müşteriler:");
        for (Customer customer : app.getCustomersWithNameContainingC()) {
            System.out.println(customer.getName());
        }
        System.out.println();

        // Haziran ayında kayıt olan müşterilerin fatura tutarlarının toplamını listeleme
        System.out.println("Haziran Ayında Kayıt Olan Müşterilerin Toplam Fatura Tutarları:");
        System.out.println(app.getTotalAmountOfInvoicesInMonth(Month.JUNE));
        System.out.println();

        // Tüm faturaları listeleme
        System.out.println("Tüm Faturalar:");
        for (Invoice invoice : app.getAllInvoices()) {
            System.out.println("Müşteri: " + invoice.getCustomer().getName() + ", Tutar: " + invoice.getAmount() + ", Ay: " + invoice.getMonth());
        }
        System.out.println();

        // 1500TL üstündeki faturaları listeleme
        System.out.println("1500TL Üstündeki Faturalar:");
        for (Invoice invoice : app.getInvoicesAboveThreshold(1500.0)) {
            System.out.println("Müşteri: " + invoice.getCustomer().getName() + ", Tutar: " + invoice.getAmount());
        }
        System.out.println();

        // 1500TL üstündeki faturaların ortalamasını hesaplama
        System.out.println("1500TL Üstündeki Faturaların Ortalaması:");
        System.out.println(app.getAverageAmountOfInvoicesAboveThreshold(1500.0));
        System.out.println();

        // 500TL altındaki faturalara sahip müşterilerin isimlerini listeleme
        System.out.println("500TL Altındaki Faturalara Sahip Müşteriler:");
        for (String customerName : app.getCustomersWithInvoicesBelowThreshold(500.0)) {
            System.out.println(customerName);
        }
        System.out.println();

        // Haziran ayını faturalarını ortalaması 750 altı olan firmaların hangi sektörde olduğunu listeleme
        System.out.println("Haziran Ayında Fatura Ortalaması 750 Altında Olan Firmaların Sektörleri:");
        for (String sector : app.getSectorsWithAvgInvoiceBelowThresholdInJune(Month.JUNE, 750.0)) {
            System.out.println(sector);
        }
    }


    }

