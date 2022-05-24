package NestedLoops.exercise;

import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int primeSum = 0;
        int nonPrimeSum = 0;
        boolean isPrime = true;

        while (!input.equals("stop")){
            int num = Integer.parseInt(input);

            if (num < 0 ){
                System.out.println("Number is negative.");
                input = scanner.nextLine();
                continue;
            }
            for (int i = 2; i < num ; i++) {
                int check = num % i;
                if (check == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                primeSum += num;
            }else{
                nonPrimeSum += num;
                isPrime = true;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%n", primeSum);
        System.out.printf("Sum of all non prime numbers is: %d", nonPrimeSum);
    }
}
