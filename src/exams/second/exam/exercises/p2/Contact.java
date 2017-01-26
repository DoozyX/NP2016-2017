package exams.second.exam.exercises.p2;

import java.util.ArrayList;
import java.util.List;

class Contact implements Comparable<Contact> {
	private String name;
	private String number;

	public Contact(String name, String number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return name + " " + number;
	}

	public List<String> getSubnumber() {
		List<String> numbers = new ArrayList<>();
		int len = number.length();
		for (int i = 0; i <= len - 3; i++) {
			for (int j = i + 3; j <= len; j++) {
				numbers.add(number.substring(i,j));
			}
		}
		return numbers;
	}

	@Override
	public int compareTo(Contact o) {
		int res = name.compareTo(o.name);
		if (res == 0) {
			return number.compareTo(o.number);
		}
		return res;
	}
}
