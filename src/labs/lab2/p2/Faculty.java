package labs.lab2.p2;

import java.util.Arrays;

class Faculty {
	private String name;
	private Student[] students;

	public Faculty(String name, Student[] students) {
		this.name = name;
		this.students = new Student[students.length];
		this.students = Arrays.copyOf(students, students.length);
	}

	public int countStudentsFromCity(String cityName) {
		int count = 0;
		for (Student s : students) {
			if (s.getCity().equals(cityName)) {
				++count;
			}
		}
		return count;
	}

	public Student getStudent(long index) {
		Student withIndex = null;
		for (Student s : students) {
			if (s.getIndex() == index) {
				withIndex = s;
			}
		}
		return withIndex;
	}

	public double getAverageNumberOfContacts() {
		double sum = 0.0;
		for (Student s : students) {
			sum += s.getContactsN();
		}
		return sum / students.length;
	}

	public Student getStudentWithMostContacts() {
		Student mostContacts = students[0];
		for (Student s : students) {
			if (s.getContactsN() > mostContacts.getContactsN()) {
				mostContacts = s;
			} else if (s.getContactsN() == mostContacts.getContactsN()) {
				if (s.getIndex() > mostContacts.getIndex()) {
					mostContacts = s;
				}
			}
		}
		return mostContacts;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("{");
		sb.append("\"fakultet\":\"").append(name).append('\"');
		sb.append(", \"studenti\":").append(Arrays.toString(students));
		sb.append('}');
		return sb.toString();
	}
}
