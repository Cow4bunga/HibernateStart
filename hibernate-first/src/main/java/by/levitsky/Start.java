package by.levitsky;

import by.levitsky.entity.Users;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;

@Log4j2
public class Start {
    public static void main(String[] args) {
        log.info("Hibernate tutorial Start");
        Session session=HibernateUtil.getSessionFactory().openSession();

        for(Users user:new UsersHelper().getUsersList()){
            System.out.println("User: "+user.getUsername());
        }
    }
}
