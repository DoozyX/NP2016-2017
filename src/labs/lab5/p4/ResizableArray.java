package labs.lab5.p4;

import java.util.Arrays;

class ResizableArray<T> {
	private T[] elements;
	private int n;

	public ResizableArray() {
		this.elements = (T[]) new Object[0];
		n = 0;
	}

	static <T> void copyAll(ResizableArray<? super T> dest, ResizableArray<? extends T> src) {
		try {
			int n = src.count();
			for (int i = 0; i < n; i++) {
				dest.addElement(src.elementAt(i));
			}
		} catch (Exception e) {
			System.out.println("error");
		}

	}

	void addElement(T element) {
		if (elements.length == n) {
			elements = Arrays.copyOf(elements, 2 * n + 1);
		}
		elements[n++] = element;
	}

	int findElement(T element) {
		for (int i = 0; i < n; i++) {
			if (elements[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	boolean removeElement(T element) {
		int pos = findElement(element);
		if (pos == -1) {
			return false;
		}
		System.arraycopy(elements, pos + 1, elements, pos, n - 1 - pos);
		elements[--n] = null;
		if (2.5 * n < elements.length) {
			elements = Arrays.copyOf(elements, elements.length / 2);
		}
		return true;
	}

	boolean contains(T element) {
		if (findElement(element) == -1) {
			return false;
		}
		return true;
	}

	Object[] toArray() {
		return Arrays.copyOf(elements, n);
	}

	@Override
	public String toString() {
		return Arrays.toString(elements);
	}

	boolean isEmpty() {
		if (n == 0) {
			return true;
		}
		return false;
	}

	int count() {
		return n;
	}

	T elementAt(int idx) throws ArrayIndexOutOfBoundsException {
		if (idx < n && idx >= 0) {
			return elements[idx];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
}
