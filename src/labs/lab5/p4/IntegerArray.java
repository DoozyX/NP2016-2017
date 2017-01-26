package labs.lab5.p4;

class IntegerArray extends ResizableArray<Integer> {
	public IntegerArray() {
		super();
	}

	double sum() {
		int sum = 0;
		int n = count();
		try {
			for (int i = 0; i < n; i++) {
				sum += elementAt(i);
			}
		} catch (Exception e) {
			System.out.println("error");
		}
		return sum;
	}

	double mean() {
		return sum() / count();
	}

	int countNonZero() {
		int count = 0;
		int n = count();
		try {
			for (int i = 0; i < n; i++) {
				if (elementAt(i) != 0) {
					++count;
				}
			}
		} catch (Exception e) {
			System.out.println("error");
		}
		return count;
	}

	IntegerArray distinct() {
		IntegerArray ia = new IntegerArray();
		int n = count();
		try {
			for (int i = 0; i < n; i++) {
				if (!ia.contains(elementAt(i))) {
					ia.addElement(elementAt(i));
				}
			}
		} catch (Exception e) {
			System.out.println("error");
		}
		return ia;
	}

	IntegerArray increment(int offset) {
		IntegerArray ia = new IntegerArray();
		int n = count();
		try {
			for (int i = 0; i < n; i++) {
				ia.addElement(elementAt(i) + offset);
			}
		} catch (Exception e) {
			System.out.println("error");
		}
		return ia;
	}
}
