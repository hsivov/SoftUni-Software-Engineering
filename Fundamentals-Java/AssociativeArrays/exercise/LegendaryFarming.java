package AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materialsMap = new LinkedHashMap<>();
        materialsMap.put("shards", 0);
        materialsMap.put("fragments", 0);
        materialsMap.put("motes", 0);
        Map<String, Integer> junkMap = new LinkedHashMap<>();
        boolean isWin = false;

        String[] inputLine = scanner.nextLine().split(" ");
        while (!isWin) {
            for (int i = 0; i < inputLine.length; i += 2) {
                int quantity = Integer.parseInt(inputLine[i]);
                String material = inputLine[i + 1].toLowerCase();

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    materialsMap.put(material, materialsMap.get(material) + quantity);
                } else {
                    if (!junkMap.containsKey(material)) {
                        junkMap.put(material, quantity);
                    } else {
                        junkMap.put(material, junkMap.get(material) + quantity);
                    }
                }
                if (materialsMap.get("shards") >= 250) {
                    System.out.println("Shadowmourne obtained!");
                    materialsMap.put("shards", materialsMap.get("shards") - 250);
                    isWin = true;
                    break;
                }
                if (materialsMap.get("fragments") >= 250) {
                    System.out.println("Valanyr obtained!");
                    materialsMap.put("fragments", materialsMap.get("fragments") - 250);
                    isWin = true;
                    break;
                }
                if (materialsMap.get("motes") >= 250) {
                    System.out.println("Dragonwrath obtained!");
                    materialsMap.put("motes", materialsMap.get("motes") - 250);
                    isWin = true;
                    break;
                }
            }
            if (!isWin){
                inputLine = scanner.nextLine().split(" ");
            }
        }
        for (Map.Entry<String, Integer> entry : materialsMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

        junkMap.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));

    }
}
