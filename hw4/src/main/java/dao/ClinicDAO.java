package dao;

import entity.clinic.Doctor;
import hibernateUtils.HibernateSessionFactoryUtis;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ClinicDAO {
    public List<Doctor> getAll() {
        Session session = HibernateSessionFactoryUtis.getSessionFactory().openSession();
        Query query = session.createQuery("select d from Doctor d join fetch d.clinic", Doctor.class);
        List<Doctor> doctors = query.getResultList();
        session.close();
        return doctors;
    }


}
