package designPatterns.singleton;

public class Database {

    private static Database instance;

    private Database() {
        try {
            Thread.sleep(4000);
            System.out.println("Database is loaded.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void readFromDB() {
        System.out.println("Reading");
    }

    public void writeToDB() {
        System.out.println("Writing");
    }
}
