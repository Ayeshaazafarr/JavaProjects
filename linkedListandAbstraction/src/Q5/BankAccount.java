package Q5;

public abstract class BankAccount {
    String accountNumber;
    double balance;

    public BankAccount(String accNum, double bal) {
        accountNumber = accNum;
        balance = bal;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }
}
