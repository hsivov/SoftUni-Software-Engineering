package ProgrammingFundamentalsFinalExam;

import java.util.*;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfHeroes = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroes = new LinkedHashMap<>();

        for (int hero = 1; hero <= numberOfHeroes; hero++) {
            String inputData = scanner.nextLine();

            String heroName = inputData.split(" ")[0];
            int hitPoints = Integer.parseInt(inputData.split(" ")[1]);
            int manaPoints = Integer.parseInt(inputData.split(" ")[2]);

            if (hitPoints > 100) {
                hitPoints = 100;
            }
            if (manaPoints > 200) {
                manaPoints = 200;
            }

            heroes.put(heroName, new ArrayList<>());
            heroes.get(heroName).add(hitPoints);
            heroes.get(heroName).add(manaPoints);
        }
        String commandLine = scanner.nextLine();
        while (!commandLine.equals("End")) {
            String command = commandLine.split(" - ")[0];
            String heroName = commandLine.split(" - ")[1];
            int heroHP = heroes.get(heroName).get(0);
            int heroMP = heroes.get(heroName).get(1);

            switch (command) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(commandLine.split(" - ")[2]);
                    String spellName = commandLine.split(" - ")[3];

                    if (neededMP <= heroMP) {
                        heroes.get(heroName).set(1, heroMP - neededMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                                heroName, spellName, heroes.get(heroName).get(1));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commandLine.split(" - ")[2]);
                    String attacker = commandLine.split(" - ")[3];

                    if (heroHP - damage > 0) {
                        heroes.get(heroName).set(0, heroHP - damage);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                heroName, damage, attacker, heroes.get(heroName).get(0));
                    } else {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        heroes.remove(heroName);
                    }
                    break;
                case "Recharge":
                    int manaRecovered = Integer.parseInt(commandLine.split(" - ")[2]);

                    if (heroMP + manaRecovered > 200) {
                        manaRecovered = 200 - heroMP;
                        heroMP = 200;
                        heroes.get(heroName).set(1, heroMP);
                    } else {
                        heroes.get(heroName).set(1, heroMP + manaRecovered);
                    }
                    System.out.printf("%s recharged for %d MP!%n", heroName, manaRecovered);
                    break;
                case "Heal":
                    int healRecovered = Integer.parseInt(commandLine.split(" - ")[2]);

                    if (heroHP + healRecovered > 100) {
                        healRecovered = 100 - heroHP;
                        heroHP = 100;
                        heroes.get(heroName).set(0, heroHP);
                    } else {
                        heroes.get(heroName).set(0, heroHP + healRecovered);
                    }
                    System.out.printf("%s healed for %d HP!%n", heroName, healRecovered);
                    break;
            }
            commandLine = scanner.nextLine();
        }
        for (Map.Entry<String, List<Integer>> entry : heroes.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("  HP: " + entry.getValue().get(0));
            System.out.println("  MP: " + entry.getValue().get(1));
        }
    }
}
