package repository;

import model.Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderRepository {

    public static Order find(int id){
        try (Session session = DbUtils.sessionFactory.openSession()) {
            return session.find(Order.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Integer create(Order order){
        Transaction transaction = null;
        try (Session session = DbUtils.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Integer orderId = (Integer) session.save(order);
            transaction.commit();
            return orderId;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }



}
