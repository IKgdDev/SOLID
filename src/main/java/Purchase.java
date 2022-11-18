import java.util.HashMap;
import java.util.Map;

public class Purchase {
    protected String title;
    protected int count;
    protected Purchase[] purchases;

    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public Purchase(int count) {
        purchases = new Purchase[count];
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

    public void printResult(Map<String, Integer> prices) {
        int sum = 0;
        System.out.println("КОРЗИНА:");
        for (Purchase purchase : purchases) {
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");
            sum += purchase.count * prices.get(purchase.title);
        }
        System.out.println("ИТОГО: " + sum);
    }
}