package ExamPreparation.JavaAdvancedExam_26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> taskStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(taskStack::push);

        ArrayDeque<Integer> threadQueue = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (!taskStack.isEmpty() && !threadQueue.isEmpty()) {
            int task = taskStack.pop();
            int thread = threadQueue.poll();

            if (task == taskToKill) {
                System.out.printf("Thread with value %d killed task %d%n", thread, task);
                threadQueue.addFirst(thread);
                break;
            }

            if (task > thread) {
                taskStack.push(task);
            }
        }

        for (Integer value : threadQueue) {
            System.out.print(value + " ");
        }
    }
}
