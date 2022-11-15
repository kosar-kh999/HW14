package Account.service;

import Account.model.Account;
import Account.repository.AccountRepository;

public class BankService {
    private static AccountRepository accountRepository = new AccountRepository();

    public void creatAccount(Account account) {
        accountRepository.creat(account);
    }

    public Account readAccount(int id) {
       return accountRepository.read(id);
    }

    public void updateAccount(int id, double balance) {
        accountRepository.update(id, balance);
    }

    public void deleteAccount(int id) {
        accountRepository.delete(id);
    }

    public void withdraw(int id, double amount, double balance) {
        accountRepository.withdraw(id, amount, balance);
    }

    public void deposit(int id, double amount, double balance) {
        accountRepository.deposit(id, amount, balance);
    }
}
