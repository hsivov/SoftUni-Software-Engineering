package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String brackets = scanner.nextLine();

        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> queue = new ArrayDeque<>();

        boolean balanced = true;

        for (int i = 0; i < brackets.length(); i++) {
            char bracket = brackets.charAt(i);
            stack.push(bracket);
            queue.offer(bracket);
        }

        for (int i = 0; i < stack.size() / 2; i++) {
            if (queue.peek() == '(' && stack.peek() != ')'){
                balanced = false;
                break;
            } else if (queue.peek() == '[' && stack.peek() != ']') {
                balanced = false;
                break;
            } else if (queue.peek() == '{' && stack.peek() != '}') {
                balanced = false;
                break;
            }
            stack.pop();
            queue.poll();
        }
        if (balanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
