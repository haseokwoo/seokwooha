package model;

import java.util.Arrays;

//Use a binary search method for insert, find, and findAll methods.
public class SortedList extends UnsortedList implements MoreListable {

	@Override
	public int[] getValues() {
		int[] array = new int[pointer];
		for (int i = 0; i < pointer; i++) {
			array[i] = values[i];
		}
		return array;
	}

	@Override
	public void insert(int pValueToInsert) {
		super.insert(pValueToInsert);
//		bubbleSort();
		selectionSort();
	}

	@Override
	public int find(int pValueToFind) {
		int position = pointer - 1;
		int position2 = position;
		int counter = pointer;
		while (true) {
			if (position == -1) {
				return -1;
			} else if (values[0] > pValueToFind) {
				return -1;
			} else if (values[position] < pValueToFind) {
				if (position == pointer - 1) {
					return -1;
				}
				position = (int) (Math.ceil(((position) + position2) / 2));
				--counter;
				if (counter == 0) {
					return -1;
				}
			} else if (values[position] > pValueToFind) {
				position2 = position;
				position = position / 2;
			} else if (values[position] == pValueToFind) {
				int firstDup = pValueToFind;
				while (firstDup == pValueToFind) {
					if (position == 0) {
						return position;
					} else {
						firstDup = values[--position];
					}
				}
				return position + 1;
			}
		}
	}

	@Override
	public int[] findAll(int pValueToFind) {
		int firstDup = values[find(pValueToFind)];
		int pointer = find(pValueToFind);
		int pointer2 = 0;
		int[] array = new int[MAX_SIZE];

		if (find(pValueToFind) != -1) {
			while (firstDup == pValueToFind && pointer < MAX_SIZE) {
				if (pointer < MAX_SIZE) {
					array[pointer2] = pointer;
					pointer++;
					if (pointer != MAX_SIZE) {
						firstDup = values[pointer];
					}
					pointer2++;
				}
			}
			return Arrays.copyOfRange(array, 0, pointer2);
		} else {
			return new int[0];
		}

	}

}
