package exams.second.exam.exercises.p1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class Subtitle {
	private static String JOINER = "-->";
	private int num;
	private LocalTime from;
	private LocalTime to;
	private String text;

	public Subtitle(int num, LocalTime from, LocalTime to, String text) {
		this.num = num;
		this.from = from;
		this.to = to;
		this.text = text;
	}

	public void shift(int ms) {
		from = from.plus(ms, ChronoUnit.MILLIS);
		to = to.plus(ms, ChronoUnit.MILLIS);
	}

	@Override
	public String toString() {
		return String.valueOf(num) + '\n' +
				from.format(DateTimeFormatter.ofPattern("HH:mm:ss,SSS")) + " " + JOINER + " " + to.format(DateTimeFormatter.ofPattern("HH:mm:ss,SSS")) + '\n' +
				text;
	}
}
