package DefiningClasses.Lab.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String command = input.split(" ")[0];

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccounts.put(bankAccount.getId(), bankAccount);
                    System.out.println("Account ID" + bankAccount.getId() + " created");
                    break;

                case "Deposit":
                    int id = Integer.parseInt(input.split(" ")[1]);
                    double amount = Double.parseDouble(input.split(" ")[2]);

                    if (!bankAccounts.containsKey(id)) {
                        System.out.println("Account does not exist");
                        input = scanner.nextLine();
                        continue;
                    }

                    bankAccount = bankAccounts.get(id);
                    bankAccount.deposit(amount);
                    System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                    break;

                case "SetInterest":
                    double interest = Double.parseDouble(input.split(" ")[1]);
                    BankAccount.setInterestRate(interest);
                    break;

                case "GetInterest":
                    id = Integer.parseInt(input.split(" ")[1]);
                    int years = Integer.parseInt(input.split(" ")[2]);

                    if (!bankAccounts.containsKey(id)) {
                        System.out.println("Account does not exist");
                        input = scanner.nextLine();
                        continue;
                    }

                    bankAccount = bankAccounts.get(id);
                    System.out.printf("%.2f%n", bankAccount.getInterestRate(years));
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
