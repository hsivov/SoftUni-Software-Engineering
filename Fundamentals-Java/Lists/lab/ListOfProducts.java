package Lists.lab;

import java.util.*;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> productList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String product = scanner.nextLine();
            productList.add(product);
        }

        Collections.sort(productList);

        for (int i = 0; i < n; i++) {
            System.out.printf("%d.%s%n", i + 1, productList.get(i));
        }
    }
}
