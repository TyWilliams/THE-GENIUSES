package products;
import java.util.Scanner;
enum Category{nickel, dime, quarter,half_dollar, dollar ,}; 
public class TheMoneymain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
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
		
		
		System.out.println("this is the price for what you want XXXXXXpriceVariableXXXXXXX");
		
		
		
		System.out.println("please enter money");
		
		System.out.println("enter the number of nickels");
		int usernumOfNickels = scan.nextInt(); // user input value location and integer data type
		System.out.println("you just entered:"+usernumOfNickels);
		totalNICKELS = usernumOfNickels * 0.05;
		//System.out.println("you just entered:"+total);
		
		
		
		
		
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
		//  if (total < XXXXXXXXpriceXXXXX)
		//	System.out.println("you dont have enough money");
		//	else if 
		
		//changes = total - XXXXXXXpriceXXXXXXX;
		
		//System.out.print("your changes is "+changes)
		
		
		
		scan.close();
	}

}
