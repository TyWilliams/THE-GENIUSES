package vendingMachineClasses;

import java.util.*;

public class Validator {
	
	//method testinput for valid conditions
	public static String validateString(Scanner input, ArrayList<?> conditions) {
		String index = "";
		index = input.nextLine().toLowerCase();
		//as long as input is not on the list method with print error
		while ((conditions.contains(index) == false)) {
			System.out.println("Error! Please enter only:\n" + conditions);
			index = input.nextLine().toLowerCase();
		}
		conditions.clear();
		return index;

	}



}