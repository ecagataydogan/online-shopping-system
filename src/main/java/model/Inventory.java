package model;

import enums.Category;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Product,Integer> productStock;

    public Inventory() {
        this.productStock = new HashMap<>();
        initializeStock();
    }

    public Map<Product, Integer> getProductStock() {
        return productStock;
    }

    public void setProductStock(Map<Product, Integer> productStock) {
        this.productStock = productStock;
    }

    private void initializeStock() {
        productStock.put(new Product("Iphone11", BigDecimal.valueOf(24502), Category.TECHNOLOGY), 10);
        productStock.put(new Product("Iphone12", BigDecimal.valueOf(35632), Category.TECHNOLOGY), 15);
        productStock.put(new Product("Macbook Pro", BigDecimal.valueOf(56321), Category.TECHNOLOGY), 5);
        productStock.put(new Product("Tooth Brush", BigDecimal.valueOf(89.20), Category.MEDICINE), 20);
        productStock.put(new Product("Vitamin B", BigDecimal.valueOf(349.99), Category.MEDICINE), 30);
        productStock.put(new Product("Jean", BigDecimal.valueOf(1543.88), Category.CLOTHING), 25);
        productStock.put(new Product("T-shirt", BigDecimal.valueOf(590), Category.CLOTHING), 40);
    }


}
