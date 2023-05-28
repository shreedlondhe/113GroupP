package E_commerce;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddToCart {
	static String username;
	static String productname;
	public static void GetUserNameAndProduct() {
		username=LogIn.Username;
		productname=ProductDetails.ProctName;
	}
	
	public static void addtocart()
	{
		GetUserNameAndProduct();

		PreparedStatement stmt = null;

		try {
			stmt = Connections.connection().prepareStatement("insert into cart(username,cart) values('"+username+"','"+productname+"')");
			stmt.executeUpdate();
			
			
//			while(CartDetails.next()) 
//			{
//				
//				
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void ViewCart() 
	{
		GetUserNameAndProduct();		
		PreparedStatement stmt = null;
              int count=1;
		try {
			stmt = Connections.connection().prepareStatement("select distinct cart from cart where username='"+username+"'");
			ResultSet GetCart = stmt.executeQuery();
			while(GetCart.next())
			{
				System.out.println("Cart product  "+"" + count + "  "+ GetCart.getString(1));
				count++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
