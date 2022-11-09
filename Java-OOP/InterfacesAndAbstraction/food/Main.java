package InterfacesAndAbstraction.food;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Buyer> buyerList = new ArrayList<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfPeople; i++) {
            String[] peopleInfo = scanner.nextLine().split("\\s+");

            String name = peopleInfo[0];
            int age = Integer.parseInt(peopleInfo[1]);
            Buyer buyer;

            if (peopleInfo.length == 4) {
                String id = peopleInfo[2];
                String birthDate = peopleInfo[3];
                buyer = new Citizen(name, age, id, birthDate);
            } else {
                String group = peopleInfo[2];
                buyer = new Rebel(name, age, group);
            }
            buyerList.add(buyer);
        }

        String inputName = scanner.nextLine();

        while (!"End".equals(inputName)){

            for (Buyer buyer : buyerList) {
                if (buyer.getName().equals(inputName)) {
                    buyer.buyFood();
                }
            }

            inputName = scanner.nextLine();
        }
        System.out.println(buyerList.stream()
                .mapToInt(Buyer::getFood)
                .sum());
    }
}
