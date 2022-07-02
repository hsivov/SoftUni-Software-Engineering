package ObjectsAndClasses.exercise.AdvertisementMessage;

import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        int times = Integer.parseInt(scanner.nextLine());
        Random random = new Random();

        for (int i = 1; i <= times; i++) {
            Advert advert = new Advert();
            advert.setLaudatoryPhrase(phrases[random.nextInt(phrases.length)]);
            advert.setEvent(events[random.nextInt(events.length)]);
            advert.setAuthor(authors[random.nextInt(authors.length)]);
            advert.setCity(cities[random.nextInt(cities.length)]);

            System.out.println(advert);
        }
    }
}
