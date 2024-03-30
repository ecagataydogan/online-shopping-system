import enums.Category;
import manager.OnlineShoppingManager;
import model.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        OnlineShoppingManager onlineShoppingManager = new OnlineShoppingManager();
        onlineShoppingManager.displayInventory();
        onlineShoppingManager.displayCustomers();
        onlineShoppingManager.addCustomer(new Customer("Niyazi", 44));
        onlineShoppingManager.displayCustomers();
        onlineShoppingManager.filterCustomers('e');
        System.out.println(onlineShoppingManager.calculateTotalBillsForJuneCustomers());
        onlineShoppingManager.displayBills();
        onlineShoppingManager.displayBillsForThresholdAbove(BigDecimal.valueOf(1500L));
        System.out.println(onlineShoppingManager.calculateAverageAmountForThreshold(BigDecimal.valueOf(1500L)));
        onlineShoppingManager.displayBillsForThresholdBelow(BigDecimal.valueOf(500L));


    }
}
