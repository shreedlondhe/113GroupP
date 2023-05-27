package E_commerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Connections {
	 
	public static Connection connection() 
	{
		Connection con=null;
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
		try {
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Shree@6517");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	

// new method to add
	
	}
	
	

