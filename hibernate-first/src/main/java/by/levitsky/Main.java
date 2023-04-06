package by.levitsky;

import by.levitsky.entity.Users;
import org.hibernate.Session;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        // create new user
        Users users=new Users();
        users.setUsername("Kingslayer");
        users.setFirstname("Vitali");
        users.setLastname("Tsal");
        users.setAge(20);
        session.save(users);

        // delete user
//        Users users1=(Users) session.load(Users.class,8);
//        session.remove(users1);

        session.getTransaction().commit();

        session.close();
        HibernateUtil.shutdown();
    }
}