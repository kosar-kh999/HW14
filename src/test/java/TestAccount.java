import Account.model.Account;
import Account.model.AccountType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import Account.repository.AccountRepository;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class TestAccount {
    private static AccountRepository accountRepository;
    @BeforeAll
    static void setAccount(){
        accountRepository = new AccountRepository();
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setAccountNumber("111223444556777889000988");
        account.setCardNumber("7776654443321112");
        account.setOpeningDate(new Date(2000, 9, 8));
        account.setBalance(10000000);
        int min = 1000;
        int max = 9999;
        account.setCvv2((int) (Math.random() * (max - min + 1) + min));
        account.setExpirationDate(new Date(2005, 6, 5));
        account.setAccountType(AccountType.LOANS);
        accountRepository.creat(account);
        assertEquals(account,accountRepository.read(1));
    }
}
