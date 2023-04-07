package by.levitsky;

import by.levitsky.entity.User;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.time.LocalDate;

@Log4j2
public class HibernateRunner {
    public static void main(String[] args) throws SQLException {
//        BlockingDeque<Connection> pool = null;
//        Connection connection = pool.take();
//        SessionFactory
//
//        Connection connection = DriverManager
//                .getConnection("db.url", "db.username", "db.password");

        Configuration configuration = new Configuration();
        //configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()){

            System.out.println("SESSION HAS BEEN OPENED");

            session.beginTransaction();
            User user = User.builder().
                    username("honorable_mention").
                    firstname("Enko").
                    lastname("Makar").
                    age(20).
                    build();

            session.save(user);
            session.getTransaction().commit();

            System.out.println("SESSION HAS BEEN CLOSED");
        }


    }
}
