package E_commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;


public class ProductBill {
	
	 private int id;  
     private String pname;  
     private int qty;  
     private double price;  
     private double totalPrice;  
        
       
      ProductBill(int id,  int qty, double price, double totalPrice)   
     {  
    	  
    	  // product bill
         this.id=id;  
         this.pname = pname;  
         this.qty = qty;  
         this.price = price;  
         this.totalPrice = totalPrice;  
     }  
          
         public int getId()   
             {  
                 return id;  
             }  
             public String getPname()   
             {  
                 return pname;  
             }  
             public int getQty()   
             {  
                 return qty;  
             }  
             public double getPrice()   
             {  
                 return price;  
             }  
             public double getTotalPrice()   
             {  
                 return totalPrice;  
             }  
              
             public static void displayFormat()   
             {  
                 System.out.format("-----------------------------------------------------------------------------------------------------------------------------------");  
                 System.out.print("\nProduct ID \t\tQuantity\t\tRate \t\t\t\tTotal Price\n");  
                 System.out.format("-----------------------------------------------------------------------------------------------------------------------------------\n");  
             }  
                
             // display  
             public void display()   
             {  
                 System.out.format("   %-9s             %-9s      %5d               %9.2f                       %14.2f\n" ,id, pname, qty, price, totalPrice);  
             }  
	
 
         public static void Bill()   
                {  
                    // variables  
                    int id ;  
                    String productName = null;  
                    int quantity = 0;   
                    double price = 0.0;  
                    double totalPrice = 0.0;  
                    double overAllPrice = 0.0;  
                    double  subtotal=0.0, discount=0.0;  
                    char choice = '\0';  
                    System.out.println("\t\t\t\t--------------------Invoice-----------------");  
                    System.out.println("\t\t\t\t\t "+"  "+"E-Commerce Shop");  
                    Scanner scan = new Scanner(System.in);  
                    System.out.print("Enter Customer Name: ");  
                    String customername=scan.nextLine();  
  
                    List<ProductBill> product = new ArrayList<ProductBill>();  
                   // Connection con=Connections.connection();
                    
                    do   
                        {  
                             
                            System.out.println("Enter the product details: ");  
                            System.out.print("Enter Product ID: ");  
                            id = scan.nextInt(); 
                            ProductDetails.productdetails(id);
                            System.out.println("Id is >>"+id);  
                            System.out.print("Quantity: ");  
                            quantity = scan.nextInt();  
                            System.out.print("Price (per unit): ");  
                            price = scan.nextDouble();  
                            //calculate total price for a particular product  
                            totalPrice = price * quantity;  
                            //calculates overall price  
                            overAllPrice = overAllPrice + totalPrice;  
                            //creates Product class object and add it to the List  
                            product.add( new ProductBill(id, quantity, price, totalPrice) );  
                            // ask for continue shopping?  
                            System.out.print("Want to add more items? (y or n): ");  
                            //reads a character Y or N  
                            choice = scan.next().charAt(0);  
                            if(choice == 'y' || choice == 'Y')
                            ProductDetails.ShowProduct(); 
                        }   
                    while (choice == 'y' || choice == 'Y');  
                    //display all product with its properties  
                    ProductBill.displayFormat();  
                    for (ProductBill p : product)   
                    {  
                        p.display();  
                    }  
                    //price calculation  
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Amount (Rs.) " +overAllPrice);  
                    //calculating discount  
                    discount = overAllPrice*2/100;  
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t    Discount (Rs.) " +discount);  
                    //total amount after discount  
                    subtotal = overAllPrice-discount;   
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t          Subtotal "+subtotal);  
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t     Invoice Total " +(subtotal));  
                    System.out.println("\t\t\t\t----------------Thank You for Shopping!!-----------------");  
                    System.out.println("\t\t\t\t                     Visit Again");  
                     
                }
                
    }  



