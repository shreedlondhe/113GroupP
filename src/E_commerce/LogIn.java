package E_commerce;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LogIn {
	static String Username=null;
	static String Password=null;
	static String User=null;
	static PreparedStatement stmt=null;
	static String passs=null;
	public static void main(String[] args) {
		LogIn.LogInUser();
	}
	
	public static void LogInUser() 
	{    
		
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("please entre your username ");
			String user = sc.next();
			stmt = Connections.connection().prepareStatement("select  username from users where username='"+user+"'");
             User=user;
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				String username = rs.getString(1);
				
				Username=username;
				
			//System.out.println("User name is  "+Username);
				
			}
			LogIn.UserNameValidation();
//			if(Username!=null) {System.out.println("User name is  "+Username);}
//			else
//			{
//				System.out.println("Ops username id not registered entre correct username");
//			LogIn.main(null);
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void UserNameValidation()
	{
		
		if(Username!=null)
		{System.out.println("User name is  "+Username);
		LogIn.Password();
		}
		else
		{
			System.out.println("Ops username id not registered entre correct username");
		LogIn.main(null);
		}
		
	}
	public static void Password()
	{try {
		Scanner sc = new Scanner(System.in);
		System.out.println("please entre your Password ");
		String pass = sc.next();
		
		passs=pass;
		stmt = Connections.connection().prepareStatement("select  passwords from users where username='"+User+"'");
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
		{
			String password = rs.getString(1);
			
			
			Password=password;
			System.out.println("this is password "+Password);
			
		//System.out.println("User name is  "+Username);
			
		}
		LogIn.PasswordValidation();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
	public static void PasswordValidation()
	{
		
		if(Password.equals(passs)) {
			System.out.println("PassWord is  "+Password);
			System.out.println("login succesfull");
		}
		else
		{
			System.out.println("Ops Password is incorrect please entre corret pass");
		LogIn.main(null);
		}
		
	}

}
