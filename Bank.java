import java.util.*;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to the Banking System");
        while (true) {
            System.out.println("\n1. Create Account\n2. Deposit\n3. Withdraw\n4. Transfer\n5. Display All Accounts\n6. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> transfer();
                case 5 -> displayAccounts();
                case 6 -> {
                    System.out.println("Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = sc.next();
        String id = UUID.randomUUID().toString();
        accounts.put(id, new Account(id, name));
        System.out.println("Account created with ID: " + id);
    }

    private void deposit() {
        System.out.print("Enter account ID: ");
        String id = sc.next();
        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();
        if (accounts.containsKey(id)) {
            accounts.get(id).deposit(amt);
        } else {
            System.out.println("Account not found.");
        }
    }

    private void withdraw() {
        System.out.print("Enter account ID: ");
        String id = sc.next();
        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();
        if (accounts.containsKey(id)) {
            accounts.get(id).withdraw(amt);
        } else {
            System.out.println("Account not found.");
        }
    }

    private void transfer() {
        System.out.print("From account ID: ");
        String from = sc.next();
        System.out.print("To account ID: ");
        String to = sc.next();
        System.out.print("Amount: ");
        double amt = sc.nextDouble();
        if (accounts.containsKey(from) && accounts.containsKey(to)) {
            if (accounts.get(from).withdraw(amt)) {
                accounts.get(to).deposit(amt);
                System.out.println("Transfer successful.");
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    private void displayAccounts() {
        for (Account acc : accounts.values()) {
            System.out.println(acc);
        }
    }
}
