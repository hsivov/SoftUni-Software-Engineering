package MidExam26June;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phoneList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("End")){
            String command = commandLine.split(" - ")[0];
            String phone = commandLine.split(" - ")[1];

            switch (command){
                case "Add":
                    if (!phoneList.contains(phone)){
                        phoneList.add(phone);
                    }
                    break;
                case "Remove":
                    phoneList.remove(phone);
                    break;
                case "Bonus phone":
                    String oldPhone = phone.split(":")[0];
                    String newPhone = phone.split(":")[1];

                    if (phoneList.contains(oldPhone)){
                        phoneList.add(phoneList.indexOf(oldPhone) + 1, newPhone);
                    }
                    break;
                case "Last":
                    if (phoneList.contains(phone)){
                        int index = phoneList.indexOf(phone);
                        String phoneToLast = phoneList.get(index);
                        phoneList.remove(index);
                        phoneList.add(phoneToLast);
                    }
                    break;
            }

            commandLine = scanner.nextLine();
        }
        System.out.println(phoneList.toString().replaceAll("[\\[\\]]", ""));
    }
}
