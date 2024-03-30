package manager;

import enums.Category;
import model.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

public class OnlineShoppingManager {
    private List<Customer> customers;
    private List<Order> orders;
    private List<Bill> bills;
    private Inventory inventory;

    public OnlineShoppingManager() {
        this.customers = createRandomCustomers();
        this.inventory = new Inventory();
        this.orders = createRandomOrders();
        this.bills = createBills(this.orders);

    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Customer> createRandomCustomers() {
        return new ArrayList<>(Arrays.asList(
                new Customer("Niyazi", 26,LocalDate.of(2023,5,21)),
                new Customer("Cem", 28,LocalDate.of(2023,6,12)),
                new Customer("Deniz", 32,LocalDate.of(2023,6,11)),
                new Customer("Kaan", 44, LocalDate.of(2023,6,5)),
                new Customer("Abdulkadir", 15, LocalDate.of(2023, 6, 9)))
        );
    }

    public List<Product> createProducts(){
        return new ArrayList<>(Arrays.asList(
                new Product("Iphone11", BigDecimal.valueOf(24502), Category.TECHNOLOGY),
                new Product("Iphone12", BigDecimal.valueOf(35632), Category.TECHNOLOGY),
                new Product("Macbook Pro", BigDecimal.valueOf(56321), Category.TECHNOLOGY),
                new Product("Tooth Brush", BigDecimal.valueOf(89.20), Category.MEDICINE),
                new Product("Vitamin B", BigDecimal.valueOf(349.99), Category.MEDICINE),
                new Product("Jean", BigDecimal.valueOf(1543.88), Category.CLOTHING),
                new Product("T-shirt", BigDecimal.valueOf(590), Category.CLOTHING)
        ));
    }

    public void displayInventory() {
        System.out.println("Inventory Contents:");
        for (Map.Entry<Product, Integer> entry : inventory.getProductStock().entrySet()) {
            Product product = entry.getKey();
            int stock = entry.getValue();
            System.out.println("Product: " + product.getName() + ", Price: " + product.getPrice() + ", Stock: " + stock);
        }
    }

    public void displayCustomers() {
        System.out.println("Customer List:");
        customers
                .forEach(customer -> System.out.println("Name: " + customer.getName()));
    }

    public void displayBills() {
        System.out.println("Bill List:");
        bills
                .forEach(bill -> System.out.println("Amount " + bill.getAmount() + " " + bill.getCustomer().getName()));
    }


    public void addCustomer(Customer newCustomer) {
        customers.add(newCustomer);
    }

    public void filterCustomers(char targetChar) {
        System.out.println("Filtered Customer List (Containing '" + targetChar + "' character):");
        customers.stream()
                .filter(customer -> customer.getName().toLowerCase().contains(String.valueOf(targetChar)))
                .forEach(customer -> System.out.println("Name: " + customer.getName()));
    }

    public List<Order> createRandomOrders() {
        List<Order> randomOrders = new ArrayList<>();
        Random random = new Random();
        for (Customer customer : customers) {
            int numOfProducts = random.nextInt(5) + 1;
            List<Product> products = new ArrayList<>();
            for (int i = 0; i < numOfProducts; i++) {
                int randomIndex = random.nextInt(inventory.getProductStock().size());
                Product randomProduct = inventory.getProductStock().keySet().toArray(new Product[0])[randomIndex];
                products.add(randomProduct);
            }
            randomOrders.add(new Order(customer, products));
        }
        return randomOrders;
    }

    public List<Bill> createBills(List<Order> orders) {
        List<Bill> bills = new ArrayList<>();
        for (Order order : orders) {
            BigDecimal totalAmount = BigDecimal.ZERO;
            for (Product product : order.getProducts()) {
                totalAmount = totalAmount.add(product.getPrice());
            }
            bills.add(new Bill(order.getCustomer(), order, totalAmount));
        }
        return bills;
    }

    public BigDecimal calculateTotalBillsForJuneCustomers() {
        System.out.println("Total bills for june customers : ");
        BigDecimal total = BigDecimal.ZERO;
        for (Bill bill : bills) {
            LocalDate registrationDate = bill.getCustomer().getRegistrationDate();
            if (registrationDate != null && registrationDate.getMonthValue() == 6) {
                BigDecimal amount = bill.getAmount();
                if (amount != null) {
                    total = total.add(amount);
                }
            }
        }
        return total;
    }

    public void displayBillsForThresholdAbove(BigDecimal threshold) {
        System.out.println("Bills above " + threshold + " TL:");
        for (Bill bill : bills) {
            BigDecimal amount = bill.getAmount();
            if (amount != null && amount.compareTo(threshold) > 0) {
                System.out.println("Customer: " + bill.getCustomer().getName() + ", Amount: " + amount);
            }
        }
    }

    public BigDecimal calculateAverageAmountForThreshold(BigDecimal threshold) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        int count = 0;
        for (Bill bill : bills) {
            BigDecimal amount = bill.getAmount();
            if (amount != null && amount.compareTo(threshold) > 0) {
                totalAmount = totalAmount.add(amount);
                count++;
            }
        }
        if (count == 0) {
            return BigDecimal.ZERO;
        } else {
            return totalAmount.divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);
        }
    }

    public void displayBillsForThresholdBelow(BigDecimal threshold) {
        System.out.println("Bills below " + threshold + " TL:");
        int count = 0;
        for (Bill bill : bills) {
            BigDecimal amount = bill.getAmount();
            if (amount != null && amount.compareTo(threshold) < 0) {
                System.out.println("Customer: " + bill.getCustomer().getName() + ", Amount: " + amount);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No bills below " + threshold + " TL" );
        }
    }

}
