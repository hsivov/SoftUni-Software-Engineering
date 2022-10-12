package Generics.Exercise.Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String name = input[0] + " " + input[1];
        String district = input[2];
        String city = input[3];

        Threeuple<String, String, String> threeuple1 = new Threeuple<>(name, district, city);
        System.out.println(threeuple1);

        input = scanner.nextLine().split(" ");
        String firstName = input[0];
        Integer littersBeer = Integer.parseInt(input[1]);
        Boolean isDrunk = input[2].equals("drunk");

        Threeuple<String, Integer, Boolean> threeuple2 = new Threeuple<>(firstName, littersBeer, isDrunk);
        System.out.println(threeuple2);

        input = scanner.nextLine().split(" ");
        name = input[0];
        Double accountBalance = Double.parseDouble(input[1]);
        String bank = input[2];

        Threeuple<String, Double, String> threeuple3 = new Threeuple<>(name, accountBalance, bank);
        System.out.println(threeuple3);
    }
}
