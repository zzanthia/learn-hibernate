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
        addr.setStreet("First Street");
        addr.setCity("First City");
        addr.setState("First State");
        addr.setPincode("100001");

        Address addr2 = new Address();
        addr2.setStreet("Second Street");
        addr2.setCity("Second City");
        addr2.setState("Second State");
        addr2.setPincode("200002");

        user.getListOfAddresses().add(addr);
        user.getListOfAddresses().add(addr2);

        //---

//        UserDetails user2 = new UserDetails();
//        user2.setUserName("Second User");
//        user2.getListOfAddresses().add(addr);
//        user2.getListOfAddresses().add(addr2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(user);
//        session.save(user2);
        session.getTransaction().commit();

        session.close();

        user = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        user = session.get(UserDetails.class, 1);
        System.out.println("User: "+user);

    }

}
