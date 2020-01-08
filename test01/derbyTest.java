import org.apache.derby.jdbc.ClientDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
 
public class derbyTest{
 
    public static void main(String[] args) {
         
        try {
        	DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        	
            String db1url = "jdbc:derby://localhost:1530/testdb1;create=true";
            String user = "impact";
            String password = "derbypass";
            Connection con1 = DriverManager.getConnection(db1url, user, password);
            if (con1 != null) {
                System.out.println("Connected to test DB #1 on OCP");
            }
             
            String db2url = "jdbc:derby://localhost:1527/testdb2";
            Properties properties = new Properties();
            properties.put("create", "true");
            properties.put("user", "tom");
            properties.put("password", "secret");
             
            Connection con2 = DriverManager.getConnection(db2url, properties);
            if (con2 != null) {
                System.out.println("Connected to test DB #2 on localhost");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}