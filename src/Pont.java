import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Pont {
    public static Connection Obtc(){
       Connection con = null ;
       try {
            Class.forName("com.mysql.jdbc.Drivers");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/apoo1","root","");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return con;
    }
}