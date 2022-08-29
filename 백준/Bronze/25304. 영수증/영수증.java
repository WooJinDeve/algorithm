import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int totalPrice = Integer.parseInt(br.readLine());
        final int productCount = Integer.parseInt(br.readLine());
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productCount; i++) {
            String[] input = br.readLine().split(" ");
            int price = Integer.parseInt(input[0]);
            int count = Integer.parseInt(input[1]);
            products.add(new Product(price, count));
        }

        //출력
        System.out.print(isTotalPriceMatchProducts(totalPrice, products) ? "Yes" : "No");

    }

    private static boolean isTotalPriceMatchProducts(int totalPrice, List<Product> products) {
        return totalPrice == products.stream().mapToInt(p -> p.count * p.product).sum();
    }

    private static class Product {
        private final int product;
        private final int count;

        public Product(int product, int count) {
            this.product = product;
            this.count = count;
        }
    }
}