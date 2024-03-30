package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private int age;
    private final LocalDate registrationDate;
    private List<Order> orders;
    private List<Bill> bills;

    public Customer(String name, int age, LocalDate registrationDate) {
        this.name = name;
        this.age = age;
        this.registrationDate = registrationDate;
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
        orders = new ArrayList<>();
        bills = new ArrayList<>();
        this.registrationDate = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", registrationDate=" + registrationDate +
                ", orders=" + orders +
                ", bills=" + bills +
                '}';
    }
}
