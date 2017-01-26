package labs.lab5.p2;


import java.time.LocalDateTime;

class Timestamp<T> implements Comparable<Timestamp<?>> {
	private final T element;
	private final LocalDateTime time;

	public Timestamp(LocalDateTime time, T element) {
		this.element = element;
		this.time = time;
	}

	public T getElement() {
		return element;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public int compareTo(Timestamp<?> t) {
		if (time.isBefore(t.getTime())) {
			return -1;
		} else if (time.isAfter(t.getTime())) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Timestamp)) return false;

		Timestamp<?> timestamp = (Timestamp<?>) o;

		return time != null ? time.equals(timestamp.time) : timestamp.time == null;
	}

	@Override
	public String toString() {
		return time.toString() + " " + element.toString();
	}
}
