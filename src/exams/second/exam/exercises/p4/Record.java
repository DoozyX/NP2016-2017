package exams.second.exam.exercises.p4;

import java.util.ArrayList;
import java.util.List;

class Record {
	private String id;
	private String program;
	private List<Integer> grades;
	private int sum;

	public Record(String id, String program) {
		this.id = id;
		this.program = program;
		this.grades = new ArrayList<>();
		sum = 0;
	}

	public void addGrade(int grade) {
		grades.add(grade);
		sum += grade;
	}

	public double getAverage() {
		return (double)sum / grades.size();
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return id + " " + String.format("%.2f",getAverage());
	}
}
