package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class pro {

	static int q;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Shree@6517");
		
	PreparedStatement stmt = con.prepareStatement("select num from t1 where id=4");
	 ResultSet rs = stmt.executeQuery();
	while(rs.next())
	{
		int x = rs.getInt(1);
		q=x;
		
	}
	
	rs.close();
			con.close();
			stmt.close();
			System.out.println("values from table is  "+q);
	}
	
}
