// Base class: BankAccount
class BankAccount {
    private String ownerName;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String ownerName, String accountNumber, double initialBalance) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Method to get the balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
}

// Subclass: OverdraftAccount
class OverdraftAccount extends BankAccount {
    private double creditLimit;

    // Constructor
    public OverdraftAccount(String ownerName, String accountNumber, double initialBalance, double creditLimit) {
        super(ownerName, accountNumber, initialBalance);
        this.creditLimit = creditLimit;
    }


    @Override
    public void withdraw(double amount) {
        double dispensableAmount = getBalance() + creditLimit;
        if (amount > 0 && amount <= dispensableAmount) {
            double newBalance = getBalance() - amount;
      
            System.out.println("Withdrawn: " + amount);
       
        } else {
            System.out.println("Withdrawal exceeds available funds and credit limit.");
        }
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Alice", "12345", 500.0);
        account.deposit(150.0);
        account.withdraw(200.0);
        System.out.println("Balance: " + account.getBalance());

        OverdraftAccount overdraftAccount = new OverdraftAccount("Bob", "67890", 300.0, 200.0);
        overdraftAccount.deposit(100.0);
        overdraftAccount.withdraw(450.0); // Should succeed
        System.out.println("Overdraft Account Balance: " + overdraftAccount.getBalance());
    }
}