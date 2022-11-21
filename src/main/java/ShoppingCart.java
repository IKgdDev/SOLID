import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    protected Purchase[] purchases;
    Map<String, Integer> products;

    public ShoppingCart(Map<String, Integer> products) {
        this.products = products;
        purchases = new Purchase[products.keySet().size()];
    }

    public void printProducts(){
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public void printResult() {
        int sum = 0;
        System.out.println("КОРЗИНА:");
        for (Purchase purchase : purchases) {
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * products.get(purchase.title)) + " руб.");
            sum += purchase.count * products.get(purchase.title);
        }
        System.out.println("ИТОГО: " + sum);
    }

}
