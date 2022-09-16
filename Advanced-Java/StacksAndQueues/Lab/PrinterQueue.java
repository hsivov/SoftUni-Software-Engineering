package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        while (!input.equals("print")) {

            if (input.equals("cancel")) {
                String output = printerQueue.isEmpty()
                        ? "Printer is on standby"
                        : "Canceled " + printerQueue.poll();
                System.out.println(output);
            } else {
                printerQueue.offer(input);
            }
            input = scanner.nextLine();
        }

        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }
    }
}
