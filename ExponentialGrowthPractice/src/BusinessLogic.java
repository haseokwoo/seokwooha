
public class BusinessLogic {

	int initialPopulation, years;
	double growthRate;
	final double percentile = 0.01;

	public double convertToPercentile() {
		return percentile;
	}

	public int getInitialPopulation() {
		return initialPopulation;
	}

	public void setInitialPopulation(int initialPopulation) {
		this.initialPopulation = initialPopulation;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public double getGrowthRate() {
		return growthRate;
	}

	public void setGrowthRate(double growthRate) {
		this.growthRate = growthRate * convertToPercentile();
	}

	public double calculateFinalPopulation() {

		return Math.floor(getInitialPopulation() * Math.pow((1 + getGrowthRate()), getYears()));
	}

}
