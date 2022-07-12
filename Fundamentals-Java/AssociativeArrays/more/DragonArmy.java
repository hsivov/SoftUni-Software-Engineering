package AssociativeArrays.more;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, Dragon>> dragonMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String type = input.split(" ")[0];
            String name = input.split(" ")[1];
            int damage;
            int health;
            int armor;

            if (input.split(" ")[2].equals("null")) {
                damage = 45;
            } else {
                damage = Integer.parseInt(input.split(" ")[2]);
            }
            if (input.split(" ")[3].equals("null")) {
                health = 250;
            } else {
                health = Integer.parseInt(input.split(" ")[3]);
            }
            if (input.split(" ")[4].equals("null")) {
                armor = 10;
            } else {
                armor = Integer.parseInt(input.split(" ")[4]);
            }

            Dragon dragon = new Dragon(damage, health, armor);

            if (isTypeExist(dragonMap, type)) {
                dragonMap.get(type).put(name, dragon);
            } else {
                dragonMap.put(type, new TreeMap<>());
                dragonMap.get(type).put(name, dragon);
            }
        }
        for (Map.Entry<String, Map<String, Dragon>> type : dragonMap.entrySet()) {
            int averageDamage = 0;
            int averageHealth = 0;
            int averageArmor = 0;
            int countDragons = 0;
            for (Map.Entry<String, Dragon> name : type.getValue().entrySet()) {
                averageDamage += name.getValue().getDamage();
                averageHealth += name.getValue().getHealth();
                averageArmor += name.getValue().getArmor();
                countDragons++;
            }
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type.getKey(),
                    averageDamage * 1.00/countDragons,
                    averageHealth * 1.00/countDragons,
                    averageArmor * 1.00/countDragons);

            for (Map.Entry<String, Dragon> name : type.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                        name.getKey(),
                        name.getValue().getDamage(),
                        name.getValue().getHealth(),
                        name.getValue().getArmor());
            }
        }
    }

    private static boolean isTypeExist(Map<String, Map<String, Dragon>> dragonMap, String type) {
        for (Map.Entry<String, Map<String, Dragon>> entry : dragonMap.entrySet()) {
            if (entry.getKey().equals(type)) {
                return true;
            }
        }
        return false;
    }
}

class Dragon {
    int damage;
    int health;
    int armor;

    public Dragon(int damage, int health, int armor) {
        this.damage = damage;
        this.health = health;
        this.armor = armor;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getArmor() {
        return armor;
    }
}
