package airline.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class conn {
	
	Connection c;
	Statement s;
	
	public conn() throws SQLException{
		

        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c =DriverManager.getConnection("jdbc:mysql:///localhost:3306/project4","root","root");
			s = c.createStatement();
		}
        
        
        catch (ClassNotFoundException e) {
        	System.out.println(e);
			e.printStackTrace();
			
		} 		
	}
	
}
