package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = "";

        ArrayDeque<String> stack = new ArrayDeque<>();

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]) {
                case "1":
                    stack.push(text);
                    text += (command[1]);
                    break;
                case "2":
                    int start = text.length() - Integer.parseInt(command[1]);
                    if (start < 0) {
                        start = 0;
                    }
                    String toRemove = text.substring(start);
                    stack.push(text);
                    text = text.replace(toRemove, "");
                    break;
                case "3":
                    int index = Integer.parseInt(command[1]);
                    if (index > 0 && index <= text.length()) {
                        System.out.println(text.charAt(index - 1));
                    }
                    break;
                case "4":
                    if (!stack.isEmpty()) {
                        text = stack.pop();
                    }
                    break;
            }
        }
    }
}
