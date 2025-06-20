package Q5;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(String accNum, double bal) {
        super(accNum, bal);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("SavingsAccount: Deposited " + amount + ", New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("SavingsAccount: Withdrew " + amount + ", New balance: " + balance);
        } else {
            System.out.println("SavingsAccount: Insufficient funds");
        }
    }
}

