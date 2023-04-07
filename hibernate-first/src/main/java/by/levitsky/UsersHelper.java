package by.levitsky;

import by.levitsky.entity.User;
import by.levitsky.entity.Users;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

// create SELECT query example using Criteria API
public class UsersHelper {
    private SessionFactory sessionFactory;

    public UsersHelper(){
        sessionFactory=HibernateUtil.getSessionFactory();
    }

    public List<Users> getUsersList(){
        Session session= sessionFactory.openSession();

        // get object by ID
        session.get(Users.class, 1);

        // Preparation part
        // Constructor for Criteria API object
        CriteriaBuilder criteriaBuilder= session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery=criteriaBuilder.createQuery(Users.class);

        // First order entity object
        Root<Users> root=criteriaQuery.from(Users.class);

        // Method to get all the users
        criteriaQuery.select(root);

        // Query execution part
        Query query=session.createQuery(criteriaQuery);

        List<Users> users=query.getResultList();

        session.close();

        return users;
    }
}
