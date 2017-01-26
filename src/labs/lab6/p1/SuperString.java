package labs.lab6.p1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

class SuperString {
	private LinkedList<String> superString;
	private Stack<String> stack;
	private HashMap<String, Boolean> reversed;

	public SuperString() {
		superString = new LinkedList<>();
		stack = new Stack<>();
		reversed = new HashMap<>();
	}

	void append(String s) {
		superString.add(s);
		stack.push(s);
		reversed.put(s, false);
	}

	void insert(String s) {
		superString.addFirst(s);
		stack.push(s);
		reversed.put(s, false);
	}

	boolean contains(String s) {
		return toString().contains(s);
	}

	void reverse() {
		LinkedList<String> temp = new LinkedList<>();
		int size = superString.size();
		for (int i = 0; i < size; i++) {
			String first = superString.getFirst();
			String reverse = new StringBuilder(first).reverse().toString();
			boolean isReversed;
			if (reversed.get(first) == null) {
				isReversed = reversed.get(reverse);
				reversed.put(reverse, !isReversed);
			} else {
				isReversed = reversed.get(first);
				reversed.put(first, !isReversed);
			}

			temp.addFirst(reverse);
			superString.removeFirst();
		}
		superString = temp;
	}

	void removeLast(int k) {
		for (int i = 0; i < k; i++) {
			String toRemove = stack.pop();
			if (reversed.get(toRemove)) {
				String reverse = new StringBuilder(toRemove).reverse().toString();
				superString.remove(reverse);
				reversed.remove(toRemove);
			} else {
				superString.remove(toRemove);
				reversed.remove(toRemove);
			}
		}
	}

	@Override
	public String toString() {
		return superString.stream().map(Object::toString).collect(Collectors.joining());
	}

	public String toStringTest() {
		return superString.toString();
	}
}
