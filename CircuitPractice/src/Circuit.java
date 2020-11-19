import java.util.ArrayList;

public class Circuit {

	public double series(int input, ArrayList<Double> array) {
		double value = 0;

		for (int y = 0; y < array.size(); y++) {
			value += array.get(y);
		}
		return value;
	}

	public double parallel(int input, ArrayList<Double> array) {
		double value2 = 0;

		for (int y = 0; y < array.size(); y++) {
			value2 += array.get(y);
		}
		value2 = 1 / value2;
		return value2;
	}
}
