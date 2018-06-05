/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza1;

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
    Scanner keyboard = new Scanner(System.in);
    
    void order()
  {


	  	// Prompts for name & determines discount
	  	System.out.print("Enter your name: " );
	  	firstName = keyboard.nextLine();

    
    }
}