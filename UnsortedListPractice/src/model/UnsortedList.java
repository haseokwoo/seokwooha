package model;

import java.util.Arrays;

public class UnsortedList implements Listable {
	public final int MAX_SIZE = 10;
	public int[] values = new int[MAX_SIZE];
	public int pointer = 0;
	public boolean duplicatesAllowed;

	@Override
	public int getSizeOfList() {
		return pointer;
	}

	@Override
	public boolean areDuplicatesAllowed() {
		return duplicatesAllowed;
	}

	@Override
	public void setDuplicatesAllowed(boolean pDuplicatesAllowed) {
		duplicatesAllowed = pDuplicatesAllowed;
	}

	@Override
	public void clear() {
		for (int i = 0; i < pointer; i++) {
			values[i] = 0;
		}
		pointer = 0;

	}

	@Override
	public void insert(int pValueToInsert) {
		if (areDuplicatesAllowed() == true) {
			if (pointer < MAX_SIZE) {
				pointer++;
				values[pointer - 1] = pValueToInsert;
			} else {
				System.out.println("Failed to insert " + pValueToInsert + ". You exceeded the maximum capacity of "
						+ MAX_SIZE + ".");
			}
		} else {
			if (pointer == 0) {
				pointer++;
				values[pointer - 1] = pValueToInsert;
			} else if (find(pValueToInsert) == -1) {
				if (pointer < MAX_SIZE) {
					pointer++;
					values[pointer - 1] = pValueToInsert;
				} else {
					System.out.println("Failed to insert " + pValueToInsert + ". You exceeded the maximum capacity of "
							+ MAX_SIZE + ".");
				}
			} else {
				if (find(pValueToInsert) != -1) {
					System.out.println(
							"Your input " + pValueToInsert + " already exists. " + "Duplicates are not allowed.");
				}
			}
		}
	}

	@Override
	public void delete(int pValueToDelete) {
		if (pointer != 0) {
			for (int i = 0; i < pointer; i++) {
				if (values[i] == pValueToDelete) {
					if (i + 1 < pointer) {
						for (int y = i; y < pointer; y++) {
							if (y + 1 < pointer) {
								values[y] = values[y + 1];
							}
						}
					}
					values[pointer - 1] = 0;
					pointer--;
					break;
				}
			}
		} else {
			System.out.println("The list is empty. Nothing to delete.");
		}

	}

	@Override
	public void deleteAll(int pValueToDelete) {
		if (pointer != 0) {
			for (int i = 0; i <= pointer; i++) {
				if (values[i] == pValueToDelete) {
					if (i + 1 < pointer) {
						for (int y = i; y < pointer; y++) {
							if (y + 1 < pointer) {
								values[y] = values[y + 1];
							}
						}
					}
					values[pointer - 1] = 0;
					pointer--;
					i = -1;
				}
			}
		} else {
			System.out.println("The list is empty. Nothing to delete.");
		}

	}

	@Override
	public void initializeWithRandomData(int pSizeOfList) {
		clear();
		if (areDuplicatesAllowed() == true) {
			for (int i = 0; i < pSizeOfList; i++) {
				values[i] = (int) (Math.random() * (10 - 1 + 1) + 1);
				pointer++;
			}
		} else {
			for (int i = 0; i < pSizeOfList; i++) {
				int rand = (int) (Math.random() * (10 - 1 + 1) + 1);
				if (find(rand) == -1) {
					values[i] = rand;
					pointer++;
					selectionSort();
				} else {
					i--;
				}
			}
		}
	}

	@Override
	public int find(int pValueToFind) {
		int position = 0;
		for (int i = 0; i < pointer; i++) {
			if (values[i] == pValueToFind) {
				position = i;
				return position;
			}
		}
		return -1;
	}

	@Override
	public int[] findAll(int pValueToFind) {
		int pointer2 = MAX_SIZE;
		int[] findAll = new int[pointer2];
		int z = -1;

		for (int i = 0; i < pointer; i++) {
			if (values[i] == pValueToFind) {
				z++;
				findAll[z] = i;
				if (z + 1 < pointer2) {
					pointer2--;
				}
			}
		}
		if (z != -1) {
			return Arrays.copyOfRange(findAll, 0, pointer2);
		} else {
			return new int[0];
		}
	}

	@Override
	public String toString() {
		int[] array = new int[pointer];
		for (int i = 0; i < pointer; i++) {
			array[i] = values[i];
		}
		return Arrays.toString(array);
	}

	@Override
	public Listable bubbleSort() {
		int[] array = values;

		for (int y = 0; y < pointer; y++) {
			if (y + 1 < pointer) {
				while (array[y] > array[y + 1]) {
					for (int i = 0; i < pointer; i++) {
						if (i + 1 < pointer) {
							if (array[i] > array[i + 1]) {
								int save = array[i + 1];
								array[i + 1] = array[i];
								array[i] = save;
							}
						}
					}
				}
			}
		}
		return this;
	}

	@Override
	public Listable selectionSort() {
		int[] array = values;

		for (int i = 0; i < pointer; i++) {
			if (i + 1 < pointer) {
				for (int y = i + 1; y < pointer; y++) {
					if (array[y] < array[i]) {
						int save = array[i];
						array[i] = array[y];
						array[y] = save;
					}
				}
			}
		}
		return this;
	}

}
