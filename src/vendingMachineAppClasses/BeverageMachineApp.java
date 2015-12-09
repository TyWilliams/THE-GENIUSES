package vendingMachineAppClasses;

import java.util.*;

import vendingMachineClasses.*;

public class BeverageMachineApp {
	BeverageMachine bm = new BeverageMachine();
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<String> ar = new ArrayList<>();
	
	private double findChange(double payment){
		double change = 0;
		//Don is coding this
		
		return change;		
	}
	
	private void payment(double price, double pay){
		while (price>0){
			price -= pay;
		}
		
		//Don is coding this
	}
	
	private static void start(){
		//set data
		String loop = "", item = "";
		do{
		System.out.println("Menu Selection:");
		//display menu  and availability using for loop
		
		System.out.println("Please select item");
			item = input.nextLine();
			//validate selection
		
		System.out.println(item.toUpperCase()+" "/*+ price*/);
		System.out.println("insert");
		//display coin menu and call payment and change methods
		
		
		System.out.println("Would you like another item?");
			loop = input.nextLine();
			//validate answer
			
		}
		while(loop.equalsIgnoreCase("yes"));
		System.out.println("Thank you for using the Genius Vending!");
	}
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to GENIUS VENDING\n-------------------------");
	}
}
