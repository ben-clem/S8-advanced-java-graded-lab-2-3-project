package repository;

import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserRepository {

    public static User find(String id){
        try (Session session = DbUtils.sessionFactory.openSession()) {
            return session.find(User.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String create(User User){
        Transaction transaction = null;
        try (Session session = DbUtils.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            String userId = (String) session.save(User);
            transaction.commit();
            return userId;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }



}
