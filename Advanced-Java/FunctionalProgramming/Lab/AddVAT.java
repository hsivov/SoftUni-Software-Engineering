package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] prices = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        UnaryOperator<Double> addVAT = value -> value * 1.20;

        System.out.println("Prices with VAT:");
        for (double price : prices) {
            double priceWithVAT = addVAT.apply(price);
            System.out.printf("%.2f%n", priceWithVAT);
        }

//        Consumer<double[]> printPricesWithVat = p -> {
//            System.out.println("Prices with VAT:");
//            System.out.println(Arrays.stream(p)
//                    .boxed()
//                    .map(addVAT)
//                    .map(d -> String.format("%.2f", d))
//                    .collect(Collectors.joining(System.lineSeparator())));
//        };
//        printPricesWithVat.accept(prices);
    }
}
