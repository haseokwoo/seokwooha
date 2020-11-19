import java.util.Scanner;

public class Presentation {

	public static void main(String[] args) {

		BusinessLogic bl = new BusinessLogic();
		Scanner keyboard = new Scanner(System.in);

		System.out.println("This program takes user given mass and velocity and calculates "
				+ "the momentum, energy, relativistic momentum, and relativistic energy of that object.\n");

		System.out.println("Please put the mass of your object: ");
		bl.setMass(keyboard.nextDouble());

		System.out.println("Please put the velocity of your object: ");
		bl.setVelocity(keyboard.nextDouble());

		System.out.printf("\nThe value of the momentum is: %.2f", bl.momentum());
		System.out.printf("\nThe value of the energy is: %.2f", bl.energy());
		System.out.printf("\nThe value of the relativistic momentum is: %.2f", bl.relativistic_momentum());
		System.out.printf("\nThe value of the relativistic energy is: %.2f", bl.relativistic_energy());

		keyboard.close();
	}

}
