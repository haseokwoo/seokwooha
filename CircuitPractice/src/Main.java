import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		Circuit c = new Circuit();

		int userChoice;
		int userInput;

		System.out.println("This program calculates series or parallel type of circuits based on user given inputs.\n");

		System.out.println("Which circuit type do you have?\n 1. Series 2. Parallel \n");
		userChoice = keyboard.nextInt();

		if (userChoice == 1) {
			System.out.println("You chose a series type of circuit.\n");
			System.out.println("How many circuits do you have?\n");
			userInput = keyboard.nextInt();
			
			ArrayList<Double> list1 = new ArrayList<>();
			double value;
			for (int i = 0; i < userInput; i++) {
				System.out.println("Please give the value of " + (i + 1) + " circuit.");
				value = keyboard.nextDouble();
				list1.add(value);
			}

			System.out.printf("Total resistance of your series circuit is: %.2f" + " Ohms.",
					c.series(userInput, list1));
		} else if (userChoice == 2) {
			System.out.println("You chose a parallel type of circuit.\n");
			System.out.println("How many circuits do you have?\n");
			userInput = keyboard.nextInt();

			ArrayList<Double> list2 = new ArrayList<>();
			double value2;
			for (int i = 0; i < userInput; i++) {
				System.out.println("Please give the value of " + (i + 1) + " circuit.");
				value2 = keyboard.nextDouble();
				value2 = 1 / value2;
				list2.add(value2);
			}

			System.out.printf("Total resistance of your parallel circuit is: %.2f" + " Ohms.",
					c.parallel(userInput, list2));
		} else {
			System.out.println("Invalid choice. Please choose either 1 or 2.");
			main(args);
		}

		keyboard.close();
	}
}
