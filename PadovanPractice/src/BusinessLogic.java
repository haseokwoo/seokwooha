//import java.util.ArrayList;

public class BusinessLogic {

	Presentation p = new Presentation();
	private int userInput;
//	ArrayList<Integer> list = new ArrayList<>();

//	public ArrayList<Integer> getList() {
//		return list;
//	}
//
//	public void setList(ArrayList<Integer> plist) {
//		if (getUserInput() < 3) {
//			plist.add(getUserInput(), 1);
//		} else {
//			list = plist;
//		}
//	}

	public int getUserInput() {
		return userInput;
	}

	public void setUserInput(int userInput) {
		userInput = userInput - 1;
		if (userInput > -1) {
			this.userInput = userInput;
		} else {
			System.out.println("Invalid input. Please enter a positive integer.");
			p.main(null);
		}
	}

//	public void padocan() {
//
//		ArrayList<Integer> list = new ArrayList<>();
//
//		list.add(0, 1);
//		list.add(1, 1);
//		list.add(2, 1);
//
//		if (getUserInput() == 1 || getUserInput() == 2 || getUserInput() == 3) {
//			System.out.println("The position of " + getUserInput() + " is: " + 1);
//		} else {
//			for (int i = 3; i < getUserInput(); i++) {
//				list.add(i, list.get(i - 2) + list.get(i - 3));
//			}
//
//			System.out.println("The position of " + getUserInput() + " is: " + list.get(list.size() - 1));
//		}
//	}

	public int padocanRecursive(int input) {

		if (input == 1 || input == 2 || input == 0) {
			return 1;
		} else {
			return padocanRecursive(input - 2) + padocanRecursive(input - 3);
		}
	}

}
