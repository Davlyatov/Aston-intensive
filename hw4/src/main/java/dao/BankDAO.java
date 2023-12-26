package dao;

import entity.bank.Bank;
import hibernateUtils.HibernateSessionFactoryUtis;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.*;

public class BankDAO {
    public List findAll() {
        Session session = HibernateSessionFactoryUtis.getSessionFactory().openSession();
        Query query = session.createNativeQuery("""
                SELECT p.full_name AS ФИО, b.name AS БАНК
                FROM Person p
                         LEFT JOIN person_bank pb ON pb.person_id = p.id
                         LEFT JOIN Bank b ON b.id = pb.bank_id""");
        List persons = query.list();
        session.close();
        return persons;
    }

    public List<Bank> getAll() {
        List<Bank> banks = new LinkedList<>();
        Session session = HibernateSessionFactoryUtis.getSessionFactory().openSession();
        Query query = session.createQuery("select b from Bank b");
        query.setReadOnly(true);
        List list = query.list();
        for (Object o : list) {
            Object[] objects = (Object[]) o;
            Bank bank = new Bank();
            bank.setId((Integer) objects[0]);
            bank.setName((String) objects[1]);
            banks.add(bank);
        }
        session.close();
        return banks;
    }
}
