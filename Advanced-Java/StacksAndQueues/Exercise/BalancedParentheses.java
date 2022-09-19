package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String brackets = scanner.nextLine();

        Deque<Character> openingBrackets = new ArrayDeque<>();

        boolean balanced = true;

        for (int i = 0; i < brackets.length(); i++) {
            char currentBracket = brackets.charAt(i);

            if (currentBracket == '(' || currentBracket == '[' || currentBracket == '{') {
                openingBrackets.push(currentBracket);
            } else {
                if (openingBrackets.isEmpty()) {
                    balanced = false;
                    break;
                }

                char lastOpeningBracket = openingBrackets.pop();
                if (currentBracket == '}' && lastOpeningBracket != '{') {
                    balanced = false;
                    break;
                } else if (currentBracket == ']' && lastOpeningBracket != '[') {
                    balanced = false;
                    break;
                } else if (currentBracket == ')' && lastOpeningBracket != '(') {
                    balanced = false;
                    break;
                }
            }
        }

        if (balanced && openingBrackets.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
