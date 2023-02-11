package edu.itstep.albums.sql;

import edu.itstep.sql.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class UsersDao {
    @PersistenceContext
    private static EntityManager em;

    public static List<Users> findAll(){

        return em.createQuery("SELECT u FROM Users u").getResultList();
    }
public static void main(String...arg){
    StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
    SessionFactory factory = meta.getSessionFactoryBuilder().build();
    EntityManager em = factory.createEntityManager();
    em.getTransaction().begin();
    List<Users> result = em.createQuery("from Users").getResultList();
    System.out.println("##################################################");
    for (Users user : result){
        System.out.println(user.getUserName() + " "+ user.getPassword());
    }
    em.getTransaction().commit();
    em.close();
}
}
