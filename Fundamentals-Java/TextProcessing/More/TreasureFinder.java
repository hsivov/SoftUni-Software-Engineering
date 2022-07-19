package TextProcessing.More;

import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] keys = scanner.nextLine().split(" ");

        String text = scanner.nextLine();
        while (!text.equals("find")) {
            StringBuilder sb = new StringBuilder();
            for (int position = 0; position < text.length(); position++) {

                char currentSymbol = text.charAt(position);
                int currentKey = Integer.parseInt(keys[position - position / keys.length * keys.length]);
                currentSymbol -= currentKey;
                sb.append(currentSymbol);
            }
            int startIndexType = sb.indexOf("&");
            int endIndexType = sb.indexOf("&", sb.indexOf("&") + 1);
            String type = sb.substring(startIndexType + 1, endIndexType);
            int coordinateStartIndex = sb.indexOf("<");
            int coordinateEndIndex = sb.indexOf(">");
            String coordinates = sb.substring(coordinateStartIndex + 1, coordinateEndIndex);

            System.out.printf("Found %s at %s%n", type, coordinates);

            text = scanner.nextLine();
        }
    }
}
