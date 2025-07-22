public class Account {
    private final String accountId;
    private final String name;
    private double balance;

    public Account(String id, String name) {
        this.accountId = id;
        this.name = name;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount + ". New balance: ₹" + balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew ₹" + amount + ". Remaining balance: ₹" + balance);
            return true;
        } else {
            System.out.println("Insufficient balance.");
            return false;
        }
    }

    public String toString() {
        return "Account ID: " + accountId + " | Name: " + name + " | Balance: ₹" + balance;
    }
}
