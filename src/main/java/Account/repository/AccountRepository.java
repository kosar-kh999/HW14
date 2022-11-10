package Account.repository;

import Account.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AccountRepository {
    private static final Configuration configuration = new Configuration().configure();
    private static final SessionFactory sessionFactory = configuration.buildSessionFactory();
    private static Account account;

    public void creat(Account card) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(card);
        transaction.commit();
        session.close();
    }

    public Account read(int id) {
        Session session = sessionFactory.openSession();
        Account account = session.get(Account.class, id);
        session.close();
        return account;
    }

    public void update(int id, double balance) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Account account = session.get(Account.class, id);
        account.setBalance(balance);
        session.update(account);
        transaction.commit();
        session.close();
    }

    public void delete(int id) {
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
        balance = balance - amount;
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
