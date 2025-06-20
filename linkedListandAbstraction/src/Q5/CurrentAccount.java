package Q5;
public class CurrentAccount extends BankAccount {
    double overdraftLimit = 500;

    public CurrentAccount(String accNum, double bal) {
        super(accNum, bal);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("CurrentAccount: Deposited " + amount + ", New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("CurrentAccount: Withdrew " + amount + ", New balance: " + balance);
        } else {
            System.out.println("CurrentAccount: Overdraft limit exceeded");
        }
    }
}

