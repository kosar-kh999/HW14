package Account.service;

import Account.model.Account;
import Account.repository.AccountRepository;

public class BankService {
    private static AccountRepository accountRepository = new AccountRepository();

    public void creatAccount(Account account) {
        accountRepository.creat(account);
    }

    public Account readAccount(int id) {
        return accountRepository.findAccount(id);
    }

    public void updateAccount(int id, double balance) {
        accountRepository.update(id,balance);
    }

    public void deleteAccount(int id) {
        accountRepository.delete(id);
    }

    public void withdraw(Account account, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Sorry, you can not withdraw a negative amount");
        }
        if (amount > account.getBalance()) {
            throw new RuntimeException("Your balance is not enough");
        }
        account.setBalance(account.getBalance() - amount);
        accountRepository.update(account.getId(),account.getBalance());
    }

    public void deposit(Account account, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Sorry, you can not deposit a negative amount");
        }
        account.setBalance(account.getBalance() + amount);
        accountRepository.update(account.getId(),account.getBalance());
    }
}
