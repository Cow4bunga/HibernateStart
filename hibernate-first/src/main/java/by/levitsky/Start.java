package by.levitsky;

import by.levitsky.entity.Users;
import org.hibernate.Session;

public class Start {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSessionFactory().openSession();

        for(Users user:new UsersHelper().getUsersList()){
            System.out.println("User: "+user.getUsername());
        }
    }
}
