package vendingMachineAppClasses;

import java.util.*;

import vendingMachineClasses.*;
import vendingMachineClasses.Currency;


public class BeverageMachineApp {
	//created object references to other classes and initialized some data in arrays
	private static BeverageMachine bm = new BeverageMachine(SelectionMenu.values().length);
	private static BeverageMachineApp bma = new BeverageMachineApp();
	private static Products p = new Products();
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<String> ar = new ArrayList<>();
	private static double cost[] = { 1.50, 1.50, 1.50, 1.25, 1.25, 1.50, 1.00 };
	private static int inv[] = { 12, 2, 4, 0, 9, 3, 10 };
	private static SelectionMenu sm[] = SelectionMenu.values();
	
	//method gets allows user insert money for item or cancel. 
	//method also keeps track of inventory, change, and payment total 
	private void makePayment(double price, SelectionMenu m) {
		//set variables to empty values
		double payment = 0, change =0, paymentTotal=0;
		int intCount=0;
		Currency insert = null;
		
		if(!(inv[m.ordinal()]==0)){
			while (price > 0) { //loop used to enter money
				System.out.printf("Item: %s   Price: $%.2f\nInsert Payment:\n", m, price);
				//validator conditions
				ar.add("nickel"); ar.add("dime");
				ar.add("quarter");ar.add("dollar");	ar.add("cancel");
				insert = Currency.valueOf(Validator.validateString(input, ar).toLowerCase()); // takes user input (insert for money) and changes it to lower case
				ar.clear();
				
				//  user will enter the money one coin at a time thur switch statement	
			switch(insert){
			 
			 case nickel:
				 payment = .5;
				 break;
			 case dime:
				 payment = .10;
				 break;
			 case dollar:
				 payment = 1.00;
				 break;
			 case quarter:
				 payment =.25;
				 break;
			 case cancel:
				// stops program because user cancel
				 payment = 0;
				 price =0;
				 continue;
			 }
				paymentTotal+=payment;
				price -= payment;
			}
			
			if(!(insert.equals(Currency.cancel))){
				//Dispenses  beverage and subtracts it from inventory
				System.out.println("Dispensing "+ m);
				inv[m.ordinal()]--;
				
				if (price<0) {
					//print statement for change
					change= Math.abs(price); // line where change set to absolute value of price
					System.out.printf("Here's Your Change: $%.2f\n\n", change);
					
				}
			}
			//condition if customer cancels
			else{
				System.out.printf("Returning Payment: $%.2f\n\n",paymentTotal );
			}
		}
		//condition if item is out of stock
		else{
			System.out.println("That item is out of stock.");
		}

	}

	//method hold function of program
	private static void start() {
		//set variables to null values
		SelectionMenu menuItem = null;
	
		String loop = "", item = "";
		double menuPrice=0;
		
		//loop while user wishes to continue
		do {
			//set data and display menu
			System.out.println("Menu Selection:");
			for (int i = 0; i < sm.length; i++) {
				p = new Products();
				bm.setProducts(p, i);
				p.setType(sm[i]);
				p.setPrice(cost[i]);
				p.setProductInv(inv[i]);
				p.setLocation(i);
				System.out.printf("%s | $%.2f", p.getType(), p.getPrice());
				if (p.getProductInv() == 0) {
					System.out.print(" | OUT OF STOCK");
				}
				System.out.println();

			}
			//prompt user to enter an item
			System.out.println("\nPlease enter an item:");
			
			//conditions for Validator
			ar.add("cocacola");ar.add("coca cola");
			ar.add("pepsi");ar.add("mountain dew");
			ar.add("mountaindew");ar.add("grape soda");
			ar.add("grapesoda");ar.add("orange soda");
			ar.add("orangesoda");ar.add("vernors");ar.add("water");
			
			//store validated answer in variable then clear conditions
			item = Validator.validateString(input, ar).toLowerCase();
			ar.clear();
			 
			//set payment based on item selection
			switch(item){
			 
			 case "cocacola": case "coca cola":
				 menuItem=SelectionMenu.CocaCola;
				 break;
			 case "pepsi": 
				 menuItem=SelectionMenu.Pepsi;
				 break;
			 case "mountain dew": case "mountaindew":
				 menuItem=SelectionMenu.MountainDew;
				 break;
			 case "grapesoda": case "grape soda":
				 menuItem=SelectionMenu.GrapeSoda;
				 break;
			 case "orangesoda": case "orange soda":
				 menuItem=SelectionMenu.OrangeSoda;
				 break;	 
			 case "vernors": 
				 menuItem=SelectionMenu.Vernors;
				 break;
			 case "water": 
				 menuItem=SelectionMenu.Water;
				 break;
			 }
		
			//get menu price and display
			menuPrice = bm.getProducts(menuItem.ordinal()).getPrice();
			System.out.printf("%s - $%.2f\n\n", menuItem, menuPrice);
			
			//cake payment method
			bma.makePayment(menuPrice, menuItem);
			
			//prompt user to restart
			System.out.println("Would you like another item?");
			
			//add validator conditions
			ar.add("yes");
			ar.add("no");
			
			//store validated info in variable and clear conditions
			loop = Validator.validateString(input, ar);
			ar.clear();
			
		//loop condition	
		} while (loop.equalsIgnoreCase("yes"));
		//print end message
		System.out.println("Thank you for using the Genius Vending!");
	}

	//main
	public static void main(String[] args) {
		//print welcome message call start method and close scanner
		System.out.println("Welcome to GENIUS VENDING\n-------------------------");
		start();
		input.close();
	}
}
