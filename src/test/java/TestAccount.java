import Account.model.Account;
import Account.model.AccountType;
import Account.service.BankService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestAccount {
    private static BankService bankService = new BankService();
    private static Account[] accounts = new Account[2];

    @BeforeAll
    static void account() {
        LocalDate openingDate = LocalDate.now();
        LocalDate expireDate = openingDate.plusYears(4);
        accounts[0] = new Account("1112", "2222222222222223", openingDate, 1000000, expireDate,
                AccountType.LOANS);
        accounts[1] = new Account("1113", "2222222222222224", openingDate, 2000000, expireDate,
                AccountType.CURRENT);
        bankService.creatAccount(accounts[0]);
        bankService.creatAccount(accounts[1]);
    }

    @Test
    public void findAccountTest() {
        Account account = bankService.readAccount(1);
        assertEquals(1,account.getId());
    }

    @Test
    public void deleteTest(){
        bankService.deleteAccount(2);
        assertNull(bankService.readAccount(2));
    }

    @Test
    public void withdrawTest(){
        bankService.withdraw(accounts[1],1000000);
        Account account = bankService.readAccount(1);
        assertEquals(1000000,account.getBalance());
    }

    @Test
    public void depositTest() {
        bankService.deposit(accounts[1], 1000000);
        Account account = bankService.readAccount(1);
        assertEquals(1000000, account.getBalance());
    }

    @Test
    public void negativeWithdrawTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> bankService.
                withdraw(accounts[1], -1000));
        assertEquals("Sorry, you can not withdraw a negative amount", exception.getMessage());
    }

    @Test
    public void negativeDepositTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> bankService.
                deposit(accounts[1], -1000));
        assertEquals("Sorry, you can not deposit a negative amount", exception.getMessage());
    }

    @Test
    public void extraWithdrawTest() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> bankService.withdraw(accounts[1],
                4000000));
        assertEquals("Your balance is not enough", exception.getMessage());
    }


}
