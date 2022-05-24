package NestedLoops.exercise;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();

        int allTickets = 0;
        int allStudentsTickets = 0;
        int allStandardTickets = 0;
        int allKidTickets = 0;

        while (!movie.equals("Finish")) {
            int freeSeats = Integer.parseInt(scanner.nextLine());
            int countStudent = 0;
            int countStandard = 0;
            int countKid = 0;
            String ticket = scanner.nextLine();

            while (!ticket.equals("End")) {
                allTickets++;
                switch (ticket) {
                    case "student":
                        countStudent++;
                        allStudentsTickets++;
                        break;
                    case "standard":
                        countStandard++;
                        allStandardTickets++;
                        break;
                    case "kid":
                        countKid++;
                        allKidTickets++;
                        break;
                }

                if (countStudent + countStandard + countKid == freeSeats){
                    break;
                }
                ticket = scanner.nextLine();
            }
            System.out.printf("%s - %.2f%% full.%n", movie, (countStudent + countStandard + countKid) * 1.00 / freeSeats * 100);
            movie = scanner.nextLine();
        }
        System.out.printf("Total tickets: %d%n", allTickets);
        System.out.printf("%.2f%% student tickets.%n", allStudentsTickets * 1.00 / allTickets * 100);
        System.out.printf("%.2f%% standard tickets.%n", allStandardTickets * 1.00 / allTickets * 100);
        System.out.printf("%.2f%% kids tickets.%n", allKidTickets * 1.00 / allTickets * 100);
    }
}
