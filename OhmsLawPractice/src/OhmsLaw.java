import java.util.Scanner;

public class OhmsLaw {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		double userVoltage;
		double userResistance;
		double userAmperage;
		int userChoice;
		
		System.out.println("\nThis program calculates an Ohm's Law based on user given inputs.\n");
		
		System.out.println("Which one do you want to caculate? \n1. Voltage 2. Resistance 3. Amperage");
		userChoice = keyboard.nextInt();
		
		if(userChoice == 1) {
			System.out.println("Please give your resistance: ");
			userResistance = keyboard.nextDouble();
			
			System.out.println("Please give your amperage: ");
			userAmperage = keyboard.nextDouble();
			
			userVoltage = userResistance * userAmperage;
			
			System.out.printf("The amperage based on your resistance " + userResistance + " and amperage " + userAmperage + " is: %.2f"
					+ " Ohms.", userVoltage);
			
			keyboard.close();
		} else if (userChoice == 2) {
			System.out.println("Please give your voltage: ");
			userVoltage = keyboard.nextDouble();
			
			System.out.println("Please give your amperage: ");
			userAmperage = keyboard.nextDouble();
			
			userResistance = userVoltage / userAmperage;
			
			System.out.printf("The amperage based on your voltage " + userVoltage + " and amperage " + userAmperage + " is: %.2f"
					+ " Ohms.", userResistance);
			
			keyboard.close();
		} else if (userChoice == 3) {
			System.out.println("Please give your voltage: ");
			userVoltage = keyboard.nextDouble();
			
			System.out.println("Please give your resistance: ");
			userResistance = keyboard.nextDouble();
			
			userAmperage = userVoltage / userResistance;
			
			System.out.printf("The amperage based on your voltage " + userVoltage + " and resistance " + userResistance + " is: %.2f"
					+ " Ohms.", userAmperage);
			
			keyboard.close();
		} else {
			System.out.println("Invalid choice. Please choose among 1 to 3.");
			main(args);
		}
		
	}

}
