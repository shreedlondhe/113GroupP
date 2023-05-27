package E_commerce;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddUser {

	public static void main(String[] args) {
		AddUser.addUser();
		LogIn.LogInUser();
	}

	public static void addUser() {

		PreparedStatement stmt = null;

		try {
			stmt = Connections.connection().prepareStatement("insert into users values(?,?,?,?,?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("please tell your First Name");
			String firstname = sc.next();
			stmt.setString(1, firstname);
			System.out.println("please tell your Last Name");
			String lastname = sc.next();
			stmt.setString(2, lastname);
			System.out.println("please tell your User Name");
			String username = sc.next();
			stmt.setString(3, username);
			System.out.println("please tell your Password");
			String password = sc.next();
			stmt.setString(4, password);
			System.out.println("please tell your City");
			String city = sc.next();
			stmt.setString(5, city);
			System.out.println("please tell your Mail ID");
			String mailid = sc.next();
			stmt.setString(6, mailid);
			System.out.println("please tell your Mobile Number");
			String mobilenumber = sc.next();
			stmt.setString(7, mobilenumber);
			int i = stmt.executeUpdate();
			System.out.println("*** User register sucsessfully ***");
			System.out.println("Please Login To continue");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Connections.connection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
