package exams.second.exam.exercises.p4;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

class StudentRecords {
	private Map<String, Program> programs;

	public StudentRecords() {
		programs = new TreeMap<>();
	}

	int readRecords(InputStream inputStream) {
		Scanner scanner = new Scanner(inputStream);
		int count = 0;
		while (scanner.hasNextLine()) {
			String[] line = scanner.nextLine().split("\\s+");
			String id = line[0];
			String program = line[1];
			int n = line.length;
			Record record = new Record(id, program);
			Program pr = programs.computeIfAbsent(program, k -> new Program(program));
			for (int i = 2; i < n; i++) {
				int grade = Integer.parseInt(line[i]);
				record.addGrade(grade);
				pr.addGrade(grade);
			}
			pr.addRecord(record);
			++count;
		}
		Collection<Program> allPrograms = programs.values();
		for (Program program: allPrograms) {
			program.sort();
		}
		return count;
	}

	void writeTable(OutputStream outputStream) {
		PrintWriter printWriter = new PrintWriter(outputStream);
		for (Program program: programs.values()) {
			printWriter.print(program);
		}
		printWriter.flush();
	}

	void writeDistribution(OutputStream outputStream) {
		List<Program> sortedByTens = programs.values().stream().sorted(Comparator.comparing(Program::getTens).reversed()).collect(Collectors.toList());
		PrintWriter printWriter = new PrintWriter(outputStream);
		for (Program program: sortedByTens) {
			printWriter.println(program.getName());
			for (Map.Entry<Integer, Integer> entry : program.getDistribution().entrySet()) {
				printWriter.printf("%2d | ", entry.getKey());
				int grades = entry.getValue();
				int n = (grades+9)/10;
				for (int i = 0; i < n; i++) {
					printWriter.print("*");
				}
				printWriter.println("(" + grades + ")");
			}
		}
		printWriter.flush();
	}
}
