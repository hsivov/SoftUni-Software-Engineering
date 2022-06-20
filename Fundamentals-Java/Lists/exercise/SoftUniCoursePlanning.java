package Lists.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessonsList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("course start")) {
            String command = commandLine.split(":")[0];
            String lesson = commandLine.split(":")[1];

            switch (command) {
                case "Add":

                    if (!lessonsList.contains(lesson)) {
                        lessonsList.add(lesson);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandLine.split(":")[2]);
                    if (!lessonsList.contains(lesson)) {
                        lessonsList.add(index, lesson);
                    }
                    break;
                case "Remove":
                    if (lessonsList.contains(lesson)) {
                        lessonsList.remove(lesson);

                        int indexTitle = lessonsList.indexOf(lesson);
                        if (lessonsList.get(indexTitle + 1).equals(lesson + "-Exercise")) {
                            lessonsList.remove(indexTitle + 1);
                        }
                    }
                    break;
                case "Swap":
                    String title1 = commandLine.split(":")[1];
                    String title2 = commandLine.split(":")[2];

                    if (lessonsList.contains(title1) && lessonsList.contains(title2)) {
                        int indexTitle1 = lessonsList.indexOf(title1);
                        int indexTitle2 = lessonsList.indexOf(title2);

                        Collections.swap(lessonsList, indexTitle1, indexTitle2);

                        String exOne = title1 + "-Exercise";
                        String exTwo = title2 + "-Exercise";
                        if (lessonsList.contains(exOne)) {
                            lessonsList.remove(lessonsList.indexOf(exOne));
                            lessonsList.add(lessonsList.indexOf(title1) + 1, exOne);
                        }
                        if (lessonsList.contains(exTwo)) {
                            lessonsList.remove(lessonsList.indexOf(exTwo));
                            lessonsList.add(lessonsList.indexOf(title2) + 1, exTwo);
                        }
                    }

                    break;
                case "Exercise":
                    String lessonTitle = commandLine.split(":")[1];
                    String exercise = lessonTitle + "-Exercise";
                    //слагаме упражнение ако има лекция и го няма
                    int indexLessonTitle = lessonsList.indexOf(lessonTitle);
                    if (lessonsList.contains(lessonTitle)) {
                        //има ли упражнение
                        if (indexLessonTitle == lessonsList.size() - 1) {
                            lessonsList.add(indexLessonTitle + 1, exercise);
                        } else if (!lessonsList.get(indexLessonTitle + 1).equals(exercise)) {
                            lessonsList.add(indexLessonTitle + 1, exercise);
                        }
                    } else {
                        lessonsList.add(lessonTitle);
                        lessonsList.add(exercise);
                    }
                    break;
            }

            commandLine = scanner.nextLine();
        }
        printSchedule(lessonsList);
    }
    public static void printSchedule(List<String> schedule){
        int count = 1;
        for (String element : schedule) {
            System.out.printf("%d.%s%n", count, element);
            count++;
        }
    }
}
