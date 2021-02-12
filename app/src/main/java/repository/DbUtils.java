package repository;

import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {
    public static String DB_URL = "jdbc:mysql://localhost:8889/ECE_S8_advanced_java_graded_lab_2&amp;3_project";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "root";

    public static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addAnnotatedClass(User.class);

            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static String USER_TABLE_QUERY = "create table if not exists User (" +
            "email String, " +
            "dateSignUp Date, " +
            "dateLastSignIn Date, " +
            "dateLastAccess Date, " +
            "password String, " +
            "primary Key (email)," +
            ")";


    public static Connection getDbConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }


    public static void initDb() {

        try {
            Statement statement = getDbConnection()
                    .createStatement();
            statement.execute(USER_TABLE_QUERY);
        } catch (SQLException e) {
            System.err.println("Product SQL error" + e.getMessage());
        }

    }

    public static void resetDb() {
        try {
            getDbConnection()
                    .createStatement()
                    .execute("DROP TABLE if exists Users");
        } catch (SQLException e) {
            System.err.println("Cannot drop table " + e.getMessage());
        }
    }

    public static void main(final String[] args) throws Exception {
        resetDb();
        DbUtils.initDb();
    }
}
