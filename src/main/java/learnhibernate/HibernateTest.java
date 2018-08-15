package learnhibernate;

import learnhibernate.dto.Address;
import learnhibernate.dto.UserDetails;
import learnhibernate.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        user.setUserName("First User");

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");

        user.setVehicle(vehicle);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(user);
        session.save(vehicle);
        session.getTransaction().commit();

        session.close();
    }

}
