import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount("Alice", "12345", 500.0);
        account.deposit(150.0);
        assertEquals(650.0, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount("Alice", "12345", 500.0);
        account.withdraw(200.0);
        assertEquals(300.0, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount("Alice", "12345", 500.0);
        account.withdraw(600.0);
        assertEquals(500.0, account.getBalance());
    }
}
