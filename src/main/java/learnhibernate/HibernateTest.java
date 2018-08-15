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

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Jeep");

        user.getVehicles().add(vehicle);
        user.getVehicles().add(vehicle2);
        vehicle.setUser(user);
        vehicle2.setUser(user);


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(user);
        session.save(vehicle);
        session.save(vehicle2);
        session.getTransaction().commit();

        session.close();

        //---read
        user = null;
        session = sessionFactory.openSession();
        user = session.get(UserDetails.class, 1);
        System.out.println("vehicles: " + user.getVehicles());
        user.getVehicles().stream().findFirst().ifPresent(v -> {
            System.out.println("First vehicle: " + v);
            System.out.println("Owner: " + v.getUser());
        });
        session.close();
    }

}
