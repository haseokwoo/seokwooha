import java.util.Scanner;

public class Presentation {

	public static void main(String[] args) {

		BusinessLogic bl = new BusinessLogic();
		Scanner keyboard = new Scanner(System.in);

		System.out.println("This program calculates the padovan sequence based on the user input.\n");

		System.out.println("Which position do you wish to display? ");
		bl.setUserInput(keyboard.nextInt());

		System.out.println(bl.padocanRecursive(bl.getUserInput()));

		keyboard.close();
	}

}
