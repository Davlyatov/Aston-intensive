package hibernateUtils;

import entity.bank.Bank;
import entity.bank.Person;
import entity.clinic.Clinic;
import entity.clinic.Doctor;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtis {

    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtis() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Bank.class);
                configuration.addAnnotatedClass(Person.class);
                configuration.addAnnotatedClass(Clinic.class);
                configuration.addAnnotatedClass(Doctor.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (HibernateException e) {
                throw new RuntimeException(e);
            }
        }
        return sessionFactory;
    }
}
