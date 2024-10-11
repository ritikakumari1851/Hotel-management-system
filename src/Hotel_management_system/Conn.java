
package Hotel_management_system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    Connection c;
    Statement s;
    Statement s2;

    Conn() {
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection to the database
            // Correct the URL format and include the port (3306 is default for MySQL)
           c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsys", "root", "system");

            // Create a statement object to execute queries
            s = c.createStatement();
            s2 =c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

