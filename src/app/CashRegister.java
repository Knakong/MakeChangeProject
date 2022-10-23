
package app;

import java.util.Scanner;

public class CashRegister {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int penny = 0;
		int nickel = 0;
		int dime = 0;
		int quarter = 0;
		int one = 0;
		int five = 0;
		int ten = 0;
		int twenty = 0;
		int fifty = 0;
	//	int hundred = 0;
		boolean isOn = true;

		System.out.println("Cash Register Makes Making Change Easy!!");
		
		

		while (isOn) {
			
			System.out.println("\nItem Price: ");

			double price = sc.nextDouble();

		
			System.out.println();
			System.out.println("What is the amount of money tendered? \n");

			double moneyIn = sc.nextDouble();
			


			double changeAmount = moneyIn - price;

			System.out.print(
					"Amount: " + price + " Tendered: " + moneyIn + " Results: ");

			sc.nextLine();
			
			if (changeAmount < .00) {
				System.out.println("  Error message");

				System.out.println("\n press [ 1 ] to for another transaction");

				String keepGoing = sc.nextLine();
				if (!keepGoing.equalsIgnoreCase("1")) {
					isOn = false;
				sc.nextLine();
				}
			}

			else if (changeAmount == 0.00) {
				System.out.print(" Exact Change");

				System.out.println("\n Enter [ 1 ] for another transaction");

				String keepGoing = sc.nextLine();
				
				if (!keepGoing.equalsIgnoreCase("1")) {
					isOn = false;
					sc.nextLine();
				
				}

			}

			else if (changeAmount > 0.00) {
				
				//hundred = theRightChange(changeAmount, 100.00); // counts how many hundreds to give in change;
				//changeAmount = remainder(changeAmount, 100.00);
				// updates the remainder change we still need to give;
				fifty = theRightChange(changeAmount, 50.00); // counts how many hundreds to give;
				changeAmount = remainder(changeAmount, 50.00);

				twenty = theRightChange(changeAmount, 20.00);
				changeAmount = remainder(changeAmount, 20.00);

				ten = theRightChange(changeAmount, 10.00);
				changeAmount = remainder(changeAmount, 10.00);

				five = theRightChange(changeAmount, 5.00);

				changeAmount = remainder(changeAmount, 5.00);

				one = theRightChange(changeAmount, 1.00);
				changeAmount = remainder(changeAmount, 1.00);

				quarter = theRightChange(changeAmount, .25);
				changeAmount = remainder(changeAmount, .25);

				dime = theRightChange(changeAmount, .10);
				changeAmount = remainder(changeAmount, .10);

				
				nickel = theRightChange(changeAmount, .05);
				
				changeAmount = remainder(changeAmount, .05);
				
				//System.out.println(changeAmount); //testing
				
				changeAmount = changeAmount + .005;
				
				// System.out.println(changeAmount); //testing
				
				penny = theRightChange(changeAmount, .01);
				
				changeAmount = remainder(changeAmount, .01);

		//	printChange(hundred, "Hundred Dollar Bill", "Hundred Dollar Bills");

				printChange(fifty, "Fifty Dollar Bill, ", "Fifty Dollar Bills, ");

				printChange(twenty, "Twenty Dollar Bill, ", "Twenty Dollar Bills, ");

				printChange(ten, "Ten Dollar Bill, ", "Ten Dollar Bills, ");

				printChange(five, "Five Dollar Bill, ", "Five Dollar Bills, ");

				printChange(one, "One Dollar Bill, ", "Two Dollar Bills, ");

				printChange(quarter, "Quarter, ", "Quarters, ");

				printChange(dime, "Dime, ", "Dimes, ");

				printChange(nickel, "Nickel , ", "Nickels, ");

				printChange(penny, "Penny. ", "Pennies. ");
				System.out.println();
				
				
				System.out.println("enter [ 1 ] to start another transcation");
				
				String keepGoing = sc.nextLine();
				if (!keepGoing.equalsIgnoreCase("1")) {
					isOn = false;
				sc.nextLine();	
				}

			
			
			
			
			
			}

		}

		System.out.print("Thanks, Come Again =)\nGoodBye!");
		
		
		sc.close();
	}

	// this method is for printing the results
	public static void printChange(int dnomCount, String dnomLabel, String dnomLabel2) { // denominations of money have
																							// be calculated and
																							// assigned
		if (dnomCount > 0 && dnomCount == 1) { // will print for one money

			System.out.print(dnomCount + " " + dnomLabel);
		} else if (dnomCount > 0) { // will print if more than one money

			System.out.print(dnomCount + " " + dnomLabel2);

		}
	}
	// This method saves the remainder and returns that value to changeAmount for
	// the next iterations for theRightChange();

	public static double remainder(double changeAmount, double dnomValue) {
		double newAmount = changeAmount;
		if (changeAmount >= dnomValue) {

			newAmount = (changeAmount % dnomValue);

		}
		return newAmount;
	}

	// This method count if and how many times one double will divide into double
	// perfect

	// returns a casted int value;

	// dnomValue is hardcoded in main and represents the money value
	public static int theRightChange(double changeAmount, double dnomValue) { // value of changeAmount will change with
																				// other method
		int tally = 0;
		
		
		/*if (changeAmount >= dnomValue || dnomValue == .01) {
			double remainder = changeAmount % dnomValue;
			//
			 * this code was no good
			 * 
			tally = (.005)+(int)((changeAmount - remainder) / dnomValue); 
		}
		
		else*/
		
		
		if (changeAmount >= dnomValue) {

			double remainder = changeAmount % dnomValue;

			tally = (int) ((changeAmount - remainder) / dnomValue); // casting double to int

		}
		return tally;
	}

}