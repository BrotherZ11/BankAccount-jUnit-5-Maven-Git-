package bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount(100);
    }

    @Test
    public void testWithdrawSufficientBalance() {
        // Assert
        assertTrue(account.withdraw(50));
        assertEquals(50, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        // Assert
        assertFalse(account.withdraw(150));
        assertEquals(100, account.getBalance());
    }

    @Test
    public void testDepositPositiveAmount() {
        // Assert
        assertEquals(150, account.deposit(50));
    }

    @Test
    public void testDepositNegativeAmount() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50));
    }

    @Test
    public void testPayment() {
        // Act
        double result = account.payment(10000, 0.001, 12);

        // Assert
        assertEquals(838.76, result, 0.01);
    }

    @Test
    public void testPending() {
        // Act
        double result = account.pending(10000, 0.001, 12, 2);

        // Assert
        assertEquals(8341.65, result, 0.01);
    }
}