package repository;

import model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class ProductRepository {

    public static Product get(int id) {
        Transaction transaction = null;
        try (Session session = DbUtils.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.getSession();
            Product product = session.get(Product.class, id);
            transaction.commit();
            return product;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    public static Product find(int id) {
        try (Session session = DbUtils.sessionFactory.openSession()) {
            return session.find(Product.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Integer create(Product product) {
        Transaction transaction = null;
        try (Session session = DbUtils.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Integer productId = (Integer) session.save(product);
            transaction.commit();
            return productId;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    public static boolean update(Product product) {
        Transaction transaction = null;
        try (Session session = DbUtils.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public static boolean delete(Product product) {
        Transaction transaction = null;
        try (Session session = DbUtils.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public static List<Product> getAll() {
        Transaction transaction = null;
        try (Session session = DbUtils.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Product");
            List<Product> list = query.list();
            transaction.commit();
            return list;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static int deleteAll() {
        Transaction transaction = null;
        try (Session session = DbUtils.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete from Product");
            int count = query.executeUpdate();
            transaction.commit();
            return count;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return -1;
        }
    }

    public static List<Product> listProductsLessThan(double maxPrice) {
        Transaction transaction = null;
        try (Session session = DbUtils.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Product where price < " + maxPrice);
            List<Product> list = query.list();
            transaction.commit();
            return list;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static int raiseProductPriceBy(double amount) {
        Transaction transaction = null;
        try (Session session = DbUtils.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Query query = session.getNamedQuery("raiseProductPriceBy");
            query.setParameter("amount", amount);
            int count = query.executeUpdate();
            transaction.commit();
            return count;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return -1;
        }
    }

}
