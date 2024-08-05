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
