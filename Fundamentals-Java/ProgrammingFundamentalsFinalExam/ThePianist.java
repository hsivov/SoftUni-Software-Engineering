package ProgrammingFundamentalsFinalExam;

import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPieces = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> masterpiecesMap = new LinkedHashMap<>();

        for (int piece = 0; piece < numberOfPieces; piece++) {
            String[] inputLine = scanner.nextLine().split("\\|");
            String pieceName = inputLine[0];
            String composer = inputLine[1];
            String key = inputLine[2];

            List<String> piecesData = new ArrayList<>();
            piecesData.add(composer);
            piecesData.add(key);
            masterpiecesMap.put(pieceName, piecesData);
        }
        String commands = scanner.nextLine();
        while (!commands.equals("Stop")){
            String command = commands.split("\\|")[0];
            String piece = commands.split("\\|")[1];

            switch (command){
                case "Add":
                    String composer = commands.split("\\|")[2];
                    String key = commands.split("\\|")[3];
                    if (masterpiecesMap.containsKey(piece)){
                        System.out.println(piece + " is already in the collection!");
                    } else {
                        masterpiecesMap.put(piece, new ArrayList<>());
                        masterpiecesMap.get(piece).add(composer);
                        masterpiecesMap.get(piece).add(key);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece,
                                masterpiecesMap.get(piece).get(0),
                                masterpiecesMap.get(piece).get(1));
                    }
                    break;
                case "Remove":
                    if (masterpiecesMap.containsKey(piece)){
                        masterpiecesMap.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = commands.split("\\|")[2];
                    if (masterpiecesMap.containsKey(piece)){
                        masterpiecesMap.get(piece).remove(1);
                        masterpiecesMap.get(piece).add(newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }
            commands = scanner.nextLine();
        }
        masterpiecesMap.forEach((key, value) -> System.out.printf("%s -> Composer: %s, Key: %s%n", key, value.get(0), value.get(1)));
    }
}
