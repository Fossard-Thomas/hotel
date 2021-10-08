package wils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {

    static final String DB_URL = "jdbc:mysql://localhost:3306/gestion_hotel?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "root";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
