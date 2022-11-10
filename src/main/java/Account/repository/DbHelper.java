package Account.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbHelper {
    private static Configuration configuration = new Configuration().configure();

    public static SessionFactory getSessionFactory() {
        return configuration.buildSessionFactory();
    }
}
