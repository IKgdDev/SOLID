import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> products = new HashMap<>();
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);


        ShoppingCart shoppingCart = new ShoppingCart(products);

        shoppingCart.printProducts();

        System.out.println("Введите два слова: название товара и количество. Или end");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            String product = parts[0];
            int count = Integer.parseInt(parts[1]);
            shoppingCart.addPurchase(product, count);
        }

        shoppingCart.printResult();
    }
}
