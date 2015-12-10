package products;  
import java.util.Scanner;
enum Category{nickel, dime, quarter,cancel, dollar ,}; //enables for a variable to be a set of predefined constants
public class TheMoneymain {

	private void makePayment(double price, SelectionMenu m) {  // method name 
		Scanner scan = new Scanner(System.in);            // for user input for money the user is entering
		double payment = 0, change =0, paymentTotal=0;   // double type & variable list and value will reset (because they are equal to zero)
		Category insert = null;                          //  categories from the enum set to null which means empty
		
while (price > 0) {                        //loop used to enter money
				System.out.printf("Item: %s   Price: $%.2f\nInsert Payment:\n", m, price);   // print statement 
				insert = Category.valueOf(scan.nextLine().toLowerCase());     // takes user input (insert for money) and changes it to lower case
			
			switch(insert){                    //  user will enter the money one coin at a time thur switch statement
			 
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
				 continue;                       // stops program because user cancel
			 }
				paymentTotal+=payment;            //
				price -= payment;
			}
			
			if (price<0) {
					change= Math.abs(price);               // line where change set to absolute value 
					System.out.printf("Here's Your Change: $%.2f\n\n", change);   //print statement for change
					
				}
		}
	
	
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		//changed to enums
		double nickel = 0.05;
		int userNumOfNickels = 0 ;
		
		double dime = 0.10;
		int userNumOfDimes ;
		
		double quarter = 0.25;
		int userNumOfQuarters ;
		
		double half_dollar = 0.50;
		int userNumOfHalfDollars ;
		
		double dollar = 1.00;
		int userNumOfDollars ;
		
		double total; 
		double usersInputtedmoney;
		
		double totalDollars;
		double totalHalfDollars;
		double totalQUARTER;
		double totalDIMES;
		double totalNICKELS;
		
		
		double price = 0;
		System.out.println("this is the price for what you want"+price);
		
		
		
		System.out.println("please enter money");
		
		System.out.println("enter the number of nickels");
		int usernumOfNickels = scan.nextInt(); // user input value location and integer data type
		System.out.println("you just entered:"+usernumOfNickels);
		totalNICKELS = usernumOfNickels * 0.05;
		//System.out.println("you just entered:"+total);
		
		
		
		
		//make user insert one coin at a time
		System.out.println("enter the number of dimes");
		int usernumOfDimes = scan.nextInt();
		totalDIMES = usernumOfDimes * 0.10;
		
		
		System.out.println("enter the number of quarter");
		int  usernumOfQuarters = scan.nextInt();
		totalQUARTER = usernumOfQuarters * 0.25;
		
		System.out.println("enter the number of half_dollar");
		int  usernumOfHalfDollars = scan.nextInt();
		totalHalfDollars = usernumOfHalfDollars * 0.50;
		
		System.out.println("enter the number of dollar");
		int  usernumOfDollars = scan.nextInt();
		totalDollars = usernumOfDollars * 1.00;
		
		
		
		
		total = totalDollars + totalHalfDollars + totalQUARTER + totalDIMES + totalNICKELS ;
		
		System.out.println("your money total is:"+total);
		
		
		double changes = 0;
		if (total < price)
		System.out.println("you dont have enough money");
		//add loop
		else 
		changes = total - price;
		
		System.out.print("your changes is "+changes);
		
		
		
		scan.close();
	}

}
