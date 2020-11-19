import java.util.Scanner;

public class Presentation {

	public static void main(String[] args) {

		BusinessLogic bl = new BusinessLogic();
		Scanner keyboard = new Scanner(System.in);

		System.out.println("This program calculates the growth rate of population based on "
				+ "user given initial population, growth rate, and years.\n");

		System.out.println("Please enter the initial population: ");
		bl.setInitialPopulation(keyboard.nextInt());

		System.out.println("Please enter the growth rate in percentile scale(%): ");
		bl.setGrowthRate(keyboard.nextDouble());

		System.out.println("Please enter the year(s): ");
		bl.setYears(keyboard.nextInt());

		System.out.println("Based on your initial population of " + bl.getInitialPopulation() + ", growth rate of "
				+ bl.getGrowthRate() + ", and year(s) of " + bl.getYears() + ", the expected final population is: "
				+ bl.calculateFinalPopulation());

		keyboard.close();

	}

}
