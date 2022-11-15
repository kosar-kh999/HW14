package Account.view;

import Account.model.Account;
import Account.model.AccountType;
import Account.service.BankService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
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
        bankService.creatAccount(account);
        Account account1 = new Account();
        account1.setAccountNumber("111223444556777889000977");
        account1.setCardNumber("7776654443321113");
        account1.setOpeningDate(new Date(2001, 10, 9));
        account1.setBalance(11000000);
        account1.setCvv2((int) (Math.random() * (max - min + 1) + min));
        account1.setExpirationDate(new Date(2006, 7, 6));
        account1.setAccountType(AccountType.CURRENT);
        bankService.creatAccount(account1);
        Account read = bankService.readAccount(1);
        System.out.println(read);
        bankService.updateAccount(1, 20000000);
        //bankService.deleteAccount(2);
        bankService.deposit(1, 1000000, account.getBalance());
        bankService.withdraw(2, 2000000, account.getBalance());
    }
}
