package ProgrammingFundamentalsFinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int barcodeCount = Integer.parseInt(scanner.nextLine());

        for (int barcode = 0; barcode < barcodeCount; barcode++) {
            String barcodeString = scanner.nextLine();

            Pattern pattern = Pattern.compile("(@#+)([A-Z][A-Za-z0-9]{4,}[A-Z])(@#+)");
            Matcher matcher = pattern.matcher(barcodeString);

            if (matcher.find()){
                String productGroup = "00";
                StringBuilder sb = new StringBuilder();
                for (char symbol : matcher.group().toCharArray()){
                    if (Character.isDigit(symbol)){
                        sb.append(symbol);
                        productGroup = sb.toString();
                    }
                }
                System.out.println("Product group: " + productGroup);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
