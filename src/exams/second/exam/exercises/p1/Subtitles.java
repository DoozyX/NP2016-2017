package exams.second.exam.exercises.p1;

import java.io.InputStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Subtitles {
	private List<Subtitle> subtitles;

	public Subtitles() {
		subtitles = new ArrayList<>();
	}

	int loadSubtitles(InputStream inputStream) {
		Scanner scanner = new Scanner(inputStream);
		int count = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			int num = Integer.parseInt(line);

			LocalTime from = LocalTime.parse(scanner.next(), DateTimeFormatter.ofPattern("HH:mm:ss,SSS"));
			scanner.next();
			LocalTime to = LocalTime.parse(scanner.next(), DateTimeFormatter.ofPattern("HH:mm:ss,SSS"));
			StringBuilder text = new StringBuilder();
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				if (line.isEmpty()) {
					break;
				}
				text.append(line).append('\n');

			}
			subtitles.add(new Subtitle(num, from,to,text.toString()));
			++count;
		}
		scanner.close();
		return count;
	}

	void print() {
		for (Subtitle subtitle : subtitles) {
			System.out.println(subtitle);
		}
	}

	void shift(int ms) {
		for (Subtitle subtitle : subtitles) {
			subtitle.shift(ms);
		}
	}

	public static void main(String[] args) {
		Subtitles sb = new Subtitles();
		sb.loadSubtitles(System.in);
	}
}
