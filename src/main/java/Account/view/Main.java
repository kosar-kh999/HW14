package Account.view;

import Account.model.Account;
import Account.model.AccountType;
import Account.service.BankService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        Account account = new Account();
        account.setAccountNumber("111223444556777889000988");
        account.setCardNumber("7776654443321112");
        account.setOpeningDate(LocalDate.now());
        account.setBalance(10000000);
        int min = 1000;
        int max = 9999;
        account.setCvv2((int) (Math.random() * (max - min + 1) + min));
        account.setExpirationDate(account.getOpeningDate().plusYears(4));
        account.setAccountType(AccountType.LOANS);
        bankService.creatAccount(account);
        Account account1 = new Account();
        account1.setAccountNumber("111223444556777889000977");
        account1.setCardNumber("7776654443321113");
        account1.setOpeningDate(LocalDate.now());
        account1.setBalance(11000000);
        account1.setCvv2((int) (Math.random() * (max - min + 1) + min));
        account1.setExpirationDate(account1.getOpeningDate().plusYears(4));
        account1.setAccountType(AccountType.CURRENT);
        bankService.creatAccount(account1);
        Account read = bankService.readAccount(1);
        System.out.println(read);
        bankService.updateAccount(1, 1000000);
        //bankService.deleteAccount(2);
        bankService.deposit(account, 1000000);
        bankService.withdraw(account1, 3000000);
    }
}
