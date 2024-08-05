import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OverdraftAccountTest {
    @Test
    public void testWithdrawWithinLimit() {
        OverdraftAccount account = new OverdraftAccount("Bob", "67890", 300.0, 200.0);
        account.withdraw(450.0);
        assertEquals(-150.0, account.getBalance() + 200.0); // Adjust for credit limit
    }

    @Test
    public void testWithdrawExceedsLimit() {
        OverdraftAccount account = new OverdraftAccount("Bob", "67890", 300.0, 200.0);
        account.withdraw(550.0);
        assertEquals(300.0, account.getBalance());
    }
}
