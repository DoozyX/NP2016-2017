package labs.lab6.p2;

import java.util.ArrayList;

class IntegerList {
	ArrayList<Integer> integerList;

	public IntegerList() {
		integerList = new ArrayList<>();
	}

	IntegerList(Integer... numbers) {
		integerList = new ArrayList<>();
		for (int i : numbers) {
			integerList.add(i);
		}
	}

	void add(int el, int idx) {
		if (idx >= integerList.size() - 1) {
			for (int i = integerList.size(); i < idx; i++) {
				integerList.add(i, 0);
			}
		}
		integerList.add(idx, el);
	}

	void remove(int idx) {
		integerList.remove(idx);
	}

	void set(int el, int idx) {
		integerList.set(idx, el);
	}

	int get(int idx) {
		return integerList.get(idx);
	}

	int size() {
		return integerList.size();
	}

	int count(int el) {
		int count = 0;
		for (int i : integerList) {
			if (i == el) {
				++count;
			}
		}
		return count;
	}

	void removeDuplicates() {
		int size = size();
		for (int i = 0; i < size; ++i) {
			boolean exist = false;
			int current = integerList.get(i);
			for (int j = i + 1; j < size; ++j) {
				if (integerList.get(j) == current) {
					exist = true;
				}
			}
			if (exist) {
				integerList.remove(i);
				--i;
				--size;
			}
		}
	}

	int sumFirst(int k) {
		int sum = 0;
		int size = size();
		for (int i = 0; i < k && i < size; i++) {
			sum += integerList.get(i);
		}
		return sum;
	}

	int sumLast(int k) {
		int sum = 0;
		int size = size();
		for (int i = size - 1; i >= size - k; --i) {
			sum += integerList.get(i);
		}
		return sum;
	}

	void shiftRight(int idx, int k) {
		if (idx < 0 || idx > integerList.size())
			throw new ArrayIndexOutOfBoundsException();
		int element = integerList.remove(idx);
		integerList.add((idx + k) % (integerList.size() + 1), element);
	}

	void shiftLeft(int idx, int k) {
		if (idx < 0 || idx > integerList.size())
			throw new ArrayIndexOutOfBoundsException();
		int element = integerList.remove(idx);
		integerList.add((idx - k + 100 * (integerList.size() + 1)) % (integerList.size() + 1), element);
	}

	IntegerList addValue(int value) {
		IntegerList iL = new IntegerList();
		int size = size();
		for (int i = 0; i < size; ++i) {
			iL.add(integerList.get(i) + value, i);
		}
		return iL;
	}
}
