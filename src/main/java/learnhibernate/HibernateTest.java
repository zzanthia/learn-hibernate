package learnhibernate;

import learnhibernate.dto.Address;
import learnhibernate.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        user.setUserName("First User");

        Address addr = new Address();
        addr.setStreet("Street Name");
        addr.setCity("City Name");

        user.setHomeAddress(addr);

        Address addr2 = new Address();
        addr2.setStreet("Second Street Name");
        addr2.setCity("Second City Name");

        user.setOfficeAddress(addr2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        user = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        user = session.get(UserDetails.class, 1);
        System.out.println("User: "+user);

    }

}
