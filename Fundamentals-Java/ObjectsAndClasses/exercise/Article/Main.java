package ObjectsAndClasses.exercise.Article;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String articleData = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        String title = articleData.split(", ")[0];
        String content = articleData.split(", ")[1];
        String author = articleData.split(", ")[2];
        Article article = new Article(title, content, author);

        for (int i = 1; i <= n; i++) {
            String commandLine = scanner.nextLine();
            String command = commandLine.split("\\: ")[0];
            String value = commandLine.split("\\: ")[1];

            switch (command) {
                case "Edit":
                    article.edit(value);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(value);
                    break;
                case "Rename":
                    article.rename(value);
                    break;
            }
        }
        System.out.println(article);
    }
}
