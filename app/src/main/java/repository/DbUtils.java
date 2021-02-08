package repository;

import model.Order;
import model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {
    public static String DB_URL = "jdbc:mysql://192.168.64.2:3306/tp4jpa";
    public static String DB_USER = "greg";
    public static String DB_PASSWORD = "";

    public static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addAnnotatedClass(Product.class);
            configuration.addAnnotatedClass(Order.class);

            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static String PRODUCT_TABLE_QUERY = "create table if not exists Product (" +
            "id integer, " +
            "name varchar(100), " +
            "price double, " +
            "o_id integer, " +
            "primary Key (id)," +
            "foreign key (o_id) references Orders(id) " +
            ")";

    public static String ORDERS_TABLE_QUERY = "create table if not exists Orders (" +
            "id integer, " +
            "date date, " +
            "primary Key (id)" +
            ")";

    public static Connection getDbConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }


    public static void initDb() {
        try {
            Statement statement = getDbConnection()
                    .createStatement();
            statement.execute(ORDERS_TABLE_QUERY);
        } catch (SQLException e) {
            System.err.println("Orders SQL error" + e.getMessage());
        }
        try {
            Statement statement = getDbConnection()
                    .createStatement();
            statement.execute(PRODUCT_TABLE_QUERY);
        } catch (SQLException e) {
            System.err.println("Product SQL error" + e.getMessage());
        }

    }

    public static void resetDb() {
        try {
            getDbConnection()
                    .createStatement()
                    .execute("DROP TABLE if exists Product");
        } catch (SQLException e) {
            System.err.println("Cannot drop table " + e.getMessage());
        }
        try {
            getDbConnection()
                    .createStatement()
                    .execute("DROP TABLE if exists Orders");
        } catch (SQLException e) {
            System.err.println("Cannot drop table " + e.getMessage());
        }
    }

    public static void main(final String[] args) throws Exception {
        resetDb();
        DbUtils.initDb();
    }
}
