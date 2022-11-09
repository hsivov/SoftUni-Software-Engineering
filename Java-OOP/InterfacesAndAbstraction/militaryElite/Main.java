package InterfacesAndAbstraction.militaryElite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Soldier> soldiers = new ArrayList<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] soldierData = input.split(" ");

            String soldierBranch = soldierData[0];
            int id = Integer.parseInt(soldierData[1]);
            String firstName = soldierData[2];
            String lastName = soldierData[3];
            double salary = Double.parseDouble(soldierData[4]);
            Corps corps;
            Soldier soldier = null;

            switch (soldierBranch) {
                case "Private":
                    soldier = new PrivateImpl(id, firstName, lastName, salary);
                    break;

                case "LieutenantGeneral":
                    LieutenantGeneral lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                    for (int i = 5; i < soldierData.length; i++) {
                        int currentId = Integer.parseInt(soldierData[i]);
                        for (Soldier priv : soldiers) {
                            if (priv.getId() == currentId) {
                                lieutenantGeneral.addPrivate((Private) priv);
                            }
                        }
                    }
                    soldier = lieutenantGeneral;
                    break;

                case "Engineer":
                    try {
                        corps = Corps.valueOf(soldierData[5]);
                        Engineer engineer = new EngineerImpl(id, firstName, lastName, salary, corps);
                        for (int i = 6; i < soldierData.length; i += 2) {
                            String partName = soldierData[i];
                            int hoursWorked = Integer.parseInt(soldierData[i + 1]);
                            Repair repair = new RepairImpl(partName, hoursWorked);
                            engineer.addRepair(repair);
                        }
                        soldier = engineer;
                    } catch (IllegalArgumentException ex) {
                        input = scanner.nextLine();
                        continue;
                    }
                    break;

                case "Commando":
                    Commando commando;
                    try {
                        corps = Corps.valueOf(soldierData[5]);
                        commando = new CommandoImpl(id, firstName, lastName, salary, corps);
                    } catch (IllegalArgumentException exception) {
                        input = scanner.nextLine();
                        continue;
                    }
                    for (int i = 6; i < soldierData.length; i += 2) {
                        try {
                            String missionCodeName = soldierData[i];
                            State missionState = State.valueOf(soldierData[i + 1]);

                            Mission mission = new MissionImpl(missionCodeName, missionState);
                            commando.addMission(mission);
                        } catch (IllegalArgumentException ignored) {

                        }
                    }
                    soldier = commando;
                    break;

                case "Spy":
                    String codeNumber = soldierData[4];
                    soldier = new SpyImpl(id,firstName, lastName, salary, codeNumber);
                    break;
            }
            soldiers.add(soldier);

            input = scanner.nextLine();
        }

        soldiers.forEach(System.out::println);
    }
}
