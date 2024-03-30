package model;

import java.math.BigDecimal;

public class Bill {
    private BigDecimal amount;
    private Customer customer;
    private Order order;

    public Bill(Customer customer, Order order, BigDecimal amount) {
        this.customer = customer;
        this.order = order;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "amount=" + amount +
                ", customer=" + customer +
                ", order=" + order +
                '}';
    }
}
