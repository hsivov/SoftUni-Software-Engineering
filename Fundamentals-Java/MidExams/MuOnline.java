package MidExams;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dungeon = scanner.nextLine().split("\\|");

        int health = 100;
        int totalBitcoins = 0;

        for (int i = 0; i < dungeon.length; i++) {
            String command = dungeon[i].split(" ")[0];

            switch (command){
                case "potion":
                    int heal = Integer.parseInt(dungeon[i].split(" ")[1]);
                    if (heal > 100 - health){
                        heal = 100 - health;
                    }
                    health += heal;
                    if (health > 100){
                        health = 100;
                    }
                    //	First print: "You healed for {amount} hp."
                    //	After that, print your current health: "Current health: {health} hp."
                    System.out.printf("You healed for %d hp.%n", heal);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    int bitcoins = Integer.parseInt(dungeon[i].split(" ")[1]);
                    totalBitcoins += bitcoins;
                    System.out.printf("You found %d bitcoins.%n", bitcoins);
                    break;
                default:
                    String monster = dungeon[i].split(" ")[0];
                    int attack = Integer.parseInt(dungeon[i].split(" ")[1]);
                    health -= attack;

                    if (health > 0){
                        System.out.printf("You slayed %s.%n", monster);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", monster);
                        System.out.printf("Best room: %d", i + 1);
                        return;
                    }
                    break;
            }
        }
        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d%n", totalBitcoins);
        System.out.printf("Health: %d", health);
    }
}
