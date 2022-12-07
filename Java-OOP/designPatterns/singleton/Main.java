package designPatterns.singleton;

public class Main {
    public static void main(String[] args) {

        connectToDB();
        connectToDB();
    }

    private static void connectToDB() {
        System.out.println("Start");
        Database database = Database.getInstance();

        database.readFromDB();
        database.writeToDB();

        System.out.println("End");
    }
}
