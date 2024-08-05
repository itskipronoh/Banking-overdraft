public class OverdraftAccount extends BankAccount {
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
            if (newBalance < 0) {
                System.out.println("Withdrawn: " + amount + " with overdraft.");
            } else {
                System.out.println("Withdrawn: " + amount);
            }
        } else {
            System.out.println("Withdrawal exceeds available funds and credit limit.");
        }
    }
}
