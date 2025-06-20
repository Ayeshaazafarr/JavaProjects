package Q5;

public class Main {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", 1000);
        CurrentAccount current = new CurrentAccount("CA456", 500);

        savings.deposit(200);
        savings.withdraw(1500);
        savings.withdraw(100);

        current.deposit(300);
        current.withdraw(1000);
        current.withdraw(100);

        System.out.println("Savings final balance: " + savings.getBalance());
        System.out.println("Current final balance: " + current.getBalance());
    }
}
