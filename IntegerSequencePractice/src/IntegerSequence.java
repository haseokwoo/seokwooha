import java.util.Scanner;

public class IntegerSequence {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int y = 0;
		int userStartingPoint;
		int userEndingPoint;
		
		System.out.println("This progarm adds all the numbers from the user put starting number to user put ending number.");
		
		System.out.println("Please enter the starting number: ");
		userStartingPoint = keyboard.nextInt();
		
		System.out.println("Please enter the ending number: ");
		userEndingPoint = keyboard.nextInt();
		
		for (int i = userStartingPoint; i <= userEndingPoint; i++) {
			y+=i;
		}
		System.out.println("The output based on your starting point " + " and ending point " + " is: " + y);
		keyboard.close();
	}

}
