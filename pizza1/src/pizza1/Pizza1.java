/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Pizza1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        pizza p1 = new pizza();
    
            p1.order();

    }
    
}

class pizza
{
    //Variables
    String firstName; // first name of user
    double distance = 0;
    double deliveryfee = 0;
    DecimalFormat df = new DecimalFormat("#.##");
    int inches=0; // pizza size
    double cost = 0.0; // pizza cost
 
    Scanner keyboard = new Scanner(System.in);
    
     void delivery_charge() 
     {
    	 System.out.print("\nPlease enter total distance in miles from pizza shop (0 for in store pickup):");

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
    	 
    	 
         System.out.println("Checking for delivery charges......... : \n");
         
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

    void pizza_details() 
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
    	         System.out.println("\nThe number you have entered is illegal, your pizza size will be set to 12 inches. " );
	         cost = 200;
	     }
	     keyboard.nextLine();
}	

             
             
  

    
    void order()
  {


	  	// Prompts for name & determines discount
	  	System.out.print("Enter your name: " );
	  	firstName = keyboard.nextLine();

                //Prompt for distance to calculate delivery charge
                delivery_charge();
		pizza_details();	
    }
}