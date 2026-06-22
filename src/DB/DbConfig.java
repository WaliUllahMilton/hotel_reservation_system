package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConfig {
    final private static String driverName ="org.postgresql.Driver";
    final private static String dbUrl = "";
    final private static String userName = "";
    final private static String password = "";

    public static void loadDBDriver(){
        try {
            Class.forName(driverName);
            System.out.println("DB Driver load successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("DB Driver load Failed");
            System.out.println(e.getMessage());
        }
    }

    public static Connection dbConnection() throws  SQLException{
            Connection con = DriverManager.getConnection(dbUrl,userName,password);
            System.out.println("DB connection successfully");
            return  con;
    }
}
