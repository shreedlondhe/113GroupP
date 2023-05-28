package E_commerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductDetails {
	static String ProctName;
	public static void main(String[] args) {
		ShowProduct();
		BuyOption();
	}
	
	public static void productdetails(int Id)
	{PreparedStatement stmt=null;
	PreparedStatement GetProductName=null;
		try {
			GetProductName = Connections.connection().prepareStatement("select ProductName from productdetails where productId='"+Id+"'");
			ResultSet ProductName = GetProductName.executeQuery();
			while(ProductName.next())
			{
			String productname = ProductName.getString(1);
			ProctName=productname;
			}
		 stmt = Connections.connection().prepareStatement("select * from productdetails where productId='"+Id+"'");
		  
		 ResultSet AllProducts = stmt.executeQuery();
		 System.out.println(" Product Details");
		 while(AllProducts.next())
		 {
			 
			 System.out.println("Product ID="+AllProducts.getString(1)+" ");
				System.out.println("ProductName="+AllProducts.getString(2)+" ");
				System.out.println("ProductDescription="+AllProducts.getString(3)+" ");
				System.out.println("AvailableQuantity="+AllProducts.getString(4)+" ");
				System.out.println("Price="+AllProducts.getString(5)+" ");
				System.out.println();
				System.out.println("             ");
		 }		 
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void ShowProduct()
	{PreparedStatement stmt=null;
	int count=1;
		try {
		 stmt = Connections.connection().prepareStatement("select productname from productdetails");
		 
		 ResultSet AllProducts = stmt.executeQuery();
		 System.out.println("Available Products");
		 while(AllProducts.next())
		 {
			 
			 
				System.out.println(count+"  "+AllProducts.getString(1)+" ");
				count++;
		 }		 
		 System.out.println("Please entre product Number to see product Details");
		 ProductDetails.SelectProduct();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void SelectProduct()
	{Scanner sc=new Scanner(System.in);
	System.out.println("");
		int Number=sc.nextInt();
	switch (Number)
	{
	case 1:{ ProductDetails.productdetails(101);}
	break;
	case 2:{ ProductDetails.productdetails(102);}
	break;
	case 3:{ ProductDetails.productdetails(103);}
	break;
	case 4:{ ProductDetails.productdetails(104);}
	break;
	case 5:{ ProductDetails.productdetails(105);}
	break;
	case 6:{ ProductDetails.productdetails(106);}
	break;
	case 7:{ ProductDetails.productdetails(107);}
	break;
	case 8:{ ProductDetails.productdetails(108);}
	break;
	case 9:{ ProductDetails.productdetails(109);}
	break;
	case 10:{ ProductDetails.productdetails(110);}
	break;
	
	default:
	{
		System.out.println("Incorrectt Choice");
		SelectProduct();
	}
	}
	}
	public static void BuyOption()

	{
		Scanner sc=new Scanner(System.in);
		System.out.println(" 1 for BuyProduct");
		System.out.println(" 2 for Go to HomePage");
		System.out.println("Please Choose Number");
			int Number=sc.nextInt();
		switch (Number) 
		{
		case 1:{
			AddToCart.addtocart();
			    System.out.println("*********** Added to cart **********"); 
			    System.out.println("Thanks for Shopping");
			    ShowProduct();
			   }
		break;
		case 2:{
			     
			     ShowProduct();
	           }
		default:
		{
			System.out.println("Incorrectt Choice");
			BuyOption();
		}
		}
	}
	public static void productdetailsAll()
	{
		PreparedStatement stmt=null;
		try {
		 stmt = Connections.connection().prepareStatement("select * from productdetails");
		 
		 ResultSet AllProducts = stmt.executeQuery();
		 System.out.println(" Product");
		 while(AllProducts.next())
		 {
			 
			 System.out.println("Product ID="+AllProducts.getString(1)+" ");
				System.out.println("ProductName="+AllProducts.getString(2)+" ");
				System.out.println("ProductDescription="+AllProducts.getString(3)+" ");
				System.out.println("AvailableQuantity="+AllProducts.getString(4)+" ");
				System.out.println("Price="+AllProducts.getString(5)+" ");
				System.out.println();
				System.out.println("             ");
		 }		 
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}
