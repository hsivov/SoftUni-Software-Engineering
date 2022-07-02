package ObjectsAndClasses.exercise.Article2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Article2> article2List = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String articleData = scanner.nextLine();
            String title = articleData.split(", ")[0];
            String content = articleData.split(", ")[1];
            String author = articleData.split(", ")[2];
            Article2 article2 = new Article2(title, content, author);
            article2List.add(article2);

            //System.out.println(article2);
        }
        String command = scanner.nextLine();


        for (Article2 item : article2List){
            System.out.println(item);
        }
    }
}
