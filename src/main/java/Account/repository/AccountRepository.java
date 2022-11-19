package Account.repository;

import Account.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AccountRepository {
    SessionFactory sessionFactory = DbHelper.getSessionFactory();

    public void creat(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
    }

    public Account findAccount(int id) {//accountNumber
        Session session = sessionFactory.openSession();
        Account account = session.get(Account.class, id);
        session.close();
        return account;
    }

    public void update(int id, double balance) {//Account account
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Account account = session.get(Account.class, id);
        account.setBalance(balance);
        session.update(account);
        transaction.commit();
        session.close();
    }

    public void delete(int id) {//Account account
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Account account = session.get(Account.class, id);
        session.delete(account);
        transaction.commit();
        session.close();
    }

    public void withdraw(int id, double amount, double balance) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if (amount < 0) {
            throw new IllegalArgumentException("Sorry, you can not withdraw a negative amount");
        }
        if (amount > balance) {
            throw new RuntimeException("Your balance is not enough");
        }
        balance = balance - amount;//todo
        Account account1 = session.get(Account.class, id);
        account1.setBalance(balance);
        session.update(account1);
        transaction.commit();
        session.close();
    }

    public void deposit(int id, double amount, double balance) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if (amount < 0) {
            throw new IllegalArgumentException("Sorry, you can not deposit a negative amount");
        }
        balance = balance + amount;
        Account account1 = session.get(Account.class, id);
        account1.setBalance(balance);
        session.update(account1);
        transaction.commit();
        session.close();
    }
}
