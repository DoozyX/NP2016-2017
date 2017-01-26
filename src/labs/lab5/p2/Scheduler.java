package labs.lab5.p2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Scheduler<T> {
	private List<Timestamp<T>> timestamps;

	public Scheduler() {
		timestamps = new ArrayList<>();
	}

	void add(Timestamp<T> t) {
		timestamps.add(t);
	}

	boolean remove(Timestamp<T> t) {
		return timestamps.remove(t);
	}

	Timestamp<T> next() {
		Timestamp<T> t = null;
		LocalDateTime now = LocalDateTime.now();

		for (Timestamp<T> aT : timestamps) {
			if (aT.getTime().isAfter(now)) {
				if (t == null) {
					t = aT;
				} else if (aT.getTime().isBefore(t.getTime())) {
					t = aT;
				}
			}
		}

		return t;
	}

	Timestamp<T> last() {
		Timestamp<T> t = null;
		LocalDateTime now = LocalDateTime.now();

		for (Timestamp<T> aT : timestamps) {
			if (aT.getTime().isBefore(now)) {
				if (t == null) {
					t = aT;
				} else if (aT.getTime().isAfter(t.getTime())) {
					t = aT;
				}
			}
		}

		return t;
	}

	List<Timestamp<T>> getAll(LocalDateTime begin, LocalDateTime end) {
		List<Timestamp<T>> tl = new ArrayList<>();
		for (Timestamp<T> aT : timestamps) {
			if (aT.getTime().isBefore(end) && aT.getTime().isAfter(begin)) {
				tl.add(aT);
			}
		}
		return tl;
	}
}
