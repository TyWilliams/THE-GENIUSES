package vendingMachineAppClasses;

import java.util.*;

import vendingMachineClasses.*;
import vendingMachineClasses.Currency;


public class BeverageMachineApp {
	private static BeverageMachine bm = new BeverageMachine(SelectionMenu.values().length);
	private static BeverageMachineApp bma = new BeverageMachineApp();
	private static Products p = new Products();
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<String> ar = new ArrayList<>();
	private static double cost[] = { 1.50, 1.50, 1.50, 1.25, 1.25, 1.50, 1.00 };
	private static int inv[] = { 12, 2, 4, 0, 9, 3, 10 };
	private static SelectionMenu sm[] = SelectionMenu.values();
	

	private void makePayment(double price, SelectionMenu m) {
		double payment = 0, change =0, paymentTotal=0;
		int intCount=0;
		Currency insert = null;
		
		if(!(inv[m.ordinal()]==0)){
			while (price > 0) {
				System.out.printf("Item: %s   Price: $%.2f\nInsert Payment:\n", m, price);
				ar.add("nickel");
				ar.add("dime");
				ar.add("quarter");
				ar.add("dollar");
				ar.add("cancel");
				insert = Currency.valueOf(Validator.validateString(input, ar).toLowerCase());
				ar.clear();
				
				
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
				 payment = 0;
				 price =0;
				 continue;
			 }
				paymentTotal+=payment;
				price -= payment;
			}
			if(!(insert.equals(Currency.cancel))){
				System.out.println("Despensing "+ m);
				inv[m.ordinal()]--;
				if (price<0) {
					change= Math.abs(price);
					System.out.printf("Here's Your Change: $%.2f\n\n", change);
					
				}
			}
			else{
				System.out.printf("Returning Payment: $%.2f\n\n",paymentTotal );
			}
		}
		else{
			System.out.println("That item is out of stock.");
		}

	}

	private static void start() {
		SelectionMenu menuItem = null;
	
		String loop = "", item = "";
		double menuPrice=0;
				
		do {
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

			System.out.println("\nPlease enter an item:");
			ar.add("cocacola");
			ar.add("coca cola");
			ar.add("pepsi");
			ar.add("mountain dew");
			ar.add("mountaindew");
			ar.add("grape soda");
			ar.add("grapesoda");
			ar.add("orange soda");
			ar.add("orangesoda");
			ar.add("vernors");
			ar.add("water");
			item = Validator.validateString(input, ar).toLowerCase();
			ar.clear();
			 
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
		
			menuPrice = bm.getProducts(menuItem.ordinal()).getPrice();
			System.out.printf("%s - $%.2f\n\n", menuItem, menuPrice);
			
			
			bma.makePayment(menuPrice, menuItem);
			System.out.println("Would you like another item?");
			ar.add("yes");
			ar.add("no");
			loop = Validator.validateString(input, ar);
			ar.clear();
			
			
		} while (loop.equalsIgnoreCase("yes"));
		System.out.println("Thank you for using the Genius Vending!");
	}

	public static void main(String[] args) {

		System.out.println("Welcome to GENIUS VENDING\n-------------------------");
		start();
		input.close();
	}
}
