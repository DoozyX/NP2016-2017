package exams.second.exam.exercises.p4;

import java.util.*;
import java.util.stream.Collectors;

class Program {
	private List<Record> records;
	private Map<Integer, Integer> distribution;
	private String name;

	public Program(String name) {
		records = new ArrayList<>();
		distribution = new TreeMap<>();
		this.name = name;
	}

	public void addRecord(Record record) {
		records.add(record);
	}

	public List<Record> getRecords() {
		return records;
	}

	public String getName() {
		return name;
	}

	public void sort() {
		records = records.stream().sorted(Comparator.comparing(Record::getAverage).reversed().thenComparing(Record::getId)).collect(Collectors.toList());
	}

	public void addGrade(int grade) {
		Integer numGrades = distribution.get(grade);
		if (numGrades != null) {
			distribution.put(grade, numGrades + 1);
		} else {
			distribution.put(grade, 1);
		}
	}

	public int getTens() {
		return distribution.get(10);
	}

	public Map<Integer, Integer> getDistribution() {
		return distribution;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(name).append('\n');
		for (Record record : records) {
			sb.append(record).append('\n');
		}
		return sb.toString();
	}
}
