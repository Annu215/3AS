package Pizza1;

import java.text.DecimalFormat;
import java.util.Scanner;

/*Java Class*/
 class Pizzatest
 {
     
    public static void main(String[] args)
    {
    	pizza p1 = new pizza();

    	try 
    	{
    		p1.order();
			p1.payment();
		} 
    	catch (InterruptedException e) 
    	{
			e.printStackTrace();
		}
    	
    }
    
 }
 
 class pizza
 {
	//  Variables
     String firstName; // first name of user
     char crustType; 
     String crust; // name of crust
     int inches=0; // pizza size
     double cost = 0.0; // pizza cost
     final double taxRate = 0.08; // amount tax owed
     double tax; // tax amount
     double total; // total of pizza + toppings
     double lastTotal; // total of everything
     int numberOfToppings = 0;
     int numberOfToppings2 =0;
     int numberOfToppings3;
     String toppings = "Cheese";
     double distance = 0;
     double deliveryfee = 0;
     DecimalFormat df = new DecimalFormat("#.##");
     Scanner keyboard = new Scanner(System.in);
     
     void delivery_charge() throws InterruptedException
     {
    	 System.out.print("\nPlease enter the total distance in kilometers from pizza shop (0 for in store pickup):");

         while(true)
         {
    	 if(keyboard.hasNextDouble())
         {
        	 distance = keyboard.nextDouble();
        	 break;
         }
    	 else
    		 System.out.print("Distance should be in numbers\nEnter the correct value : ");
         	keyboard.nextLine();
         }
    	 
    	 Thread.sleep(500);
         System.out.println("Checking for delivery charges......... : \n");
         Thread.sleep(500);
         if (distance == 0)
         {
         deliveryfee = 0;
         System.out.println("There is no delivery fee.");
         }
         else if (distance > 1)
         {
         deliveryfee = ((distance * 5) +100);
         System.out.println("Your delivery fee is: Rs " + df.format(deliveryfee));
         }
         else if (distance > 0)
         {
         deliveryfee = 100.00;
         System.out.println("Your delivery fee is: Rs " + df.format(deliveryfee));
         }
     }
     
  void order()
  {


	  	// Prompts for name & determines discount
	  	System.out.print("Enter your name: " );
	  	firstName = keyboard.nextLine();

     	
		try 
		{
			//Prompt for distance to calculate delivery charge
			delivery_charge();
			
			//Type of Pizza need
			pizza_details();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}

    

  }
  
  void pizza_details() throws InterruptedException
  {
	  // Prompts for pizza size
	     System.out.print("\nWhat size of pizza would you like (diameter in inches)? (10,   12, 14, or 16) " );
	     if(keyboard.hasNextInt())
	    	 inches = keyboard.nextInt();
  
	     if (inches == 10 )
	     {
	         cost = 150;
	     }
	     else if (inches == 12)
	     {
	         cost = 200;
	     }
	     else if (inches == 14)
	     {
	         cost = 300;
	     }
	     else if (inches == 16)
	     {
	         cost = 400;
	     }
	     else if (inches != 10 && inches != 12 && inches != 14 && inches != 16)
	     {
	    	 Thread.sleep(500);
	         System.out.println("\nThe number you have entered is illegal, your pizza size will be set to 12 inches. " );
	         cost = 200;
	     }
	     keyboard.nextLine();
	
             pizzacrust();
             
  }
  
  
  
  void pizzacrust() throws InterruptedException
  {
        // Prompts user for type of crust
	     System.out.print("\nWhat type of crust do you want? (H)Hand-Tossed, (T)Thin-crust, or (D)Deep-dish (enter H, T, or D,): " );
	     crustType = keyboard.nextLine().charAt(0);

	     if (crustType == 'H' || crustType == 'h' )
	     {
	         crust = "Hand-Tossed";
	     }
	     else if (crustType == 'T' || crustType == 't' )
	     {
	         crust = "Thin-Crust";
	     }
	     else if (crustType == 'D' || crustType == 'd' )
	     {
	         crust = "Deep-Dish";
	     }
	     else if (crustType != 'H' && crustType != 'h' && crustType != 'T' && crustType    != 't' && crustType != 'D' && crustType != 'd' )
	     {
	    	 Thread.sleep(500);
	         System.out.println("The crust type you have entered is illegal, your crust type will be set to hand-tossed. " );
	     }
	         crust = "Hand-Tossed";
               
                pizza_toppings();
	    
  }
  
  void pizza_toppings() throws InterruptedException
  {
                   Thread.sleep(500);
	     // Prompts user for additonal toppings
	     System.out.println("All pizzas come with cheese." );
	     System.out.println("\nAdditional toppings are Rs 80 each, choose from Pepperoni or Sausage." );

	     Thread.sleep(500);
	     // Pepperoni
	     System.out.println("\nDo you want Pepperoni? (Y/N)" );
	     numberOfToppings = keyboard.nextLine().charAt(0);
	     if (numberOfToppings == 'Y' || numberOfToppings == 'y' )
	     {
	         numberOfToppings = 1;
	         toppings = toppings + " and Pepperoni";
	     }
	     else
	     {
	         numberOfToppings = 0;
	     }

	     Thread.sleep(500);
	     //Sausage
	     System.out.println("\nDo you want Sausage? (Y/N)" );
	     numberOfToppings2 = keyboard.nextLine().charAt(0);
	     if (numberOfToppings2 == 'Y' || numberOfToppings2 == 'y' )
	     {
	         numberOfToppings2 = 1;
	         toppings = toppings + " and Sausage";
	     }
	     else
	     {
	         numberOfToppings2 = 0;
	     } 

	     numberOfToppings3 = (numberOfToppings) + (numberOfToppings2);

	     // Calculations
	     total = (cost) + (numberOfToppings3 * 1.25) + (deliveryfee);
	     tax = total * taxRate;
	     lastTotal = total * ( 1 + taxRate );
             Thread.sleep(500);
            

  }
  void payment() throws InterruptedException
  {
	     // Payment Confirmation
	     System.out.println(firstName + ", here is your order:"); 
	     System.out.println(inches + " inch pizza");
	     System.out.println(crust +", " + toppings);
	     Thread.sleep(500);
	     System.out.println("Order Cost: Rs " + df.format(total));
	     Thread.sleep(500);
	     System.out.println("Tax\nSGST: Rs " + (df.format(tax/2)));
	     System.out.println("CGST: Rs " + (df.format(tax/2)));
	     System.out.println("Total Rs " + (df.format(tax)));
	     System.out.println("Total Due: Rs " + df.format(lastTotal));
  }
 
 }
