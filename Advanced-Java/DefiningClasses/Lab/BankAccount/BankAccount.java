package DefiningClasses.Lab.BankAccount;

public class BankAccount {

    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccount = 1;
    private final int id;
    private double balance;

    BankAccount() {
        this.id = bankAccount++;
    }

    static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit (double amount) {
        this.balance += amount;
    }

    public double getInterestRate(int years) {
        return interestRate * years * balance;
    }

    public int getId() {
        return id;
    }
}
