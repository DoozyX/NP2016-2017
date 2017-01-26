package labs.lab8.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.TreeMap;

class Scheduler<T> {
	TreeMap<Date, T> scheduler;

	public Scheduler() {
		this.scheduler = new TreeMap<>();
	}

	void add(Date d, T t) {
		scheduler.put(d, t);
	}

	boolean remove(Date d) {
		return scheduler.remove(d) != null;
	}

	T next() {
		Date now = new Date();
		Date key = scheduler.tailMap(now).firstKey();
		return scheduler.get(key);
	}

	T last() {
		Date now = new Date();
		Date key = scheduler.headMap(now).lastKey();
		return scheduler.get(key);
	}

	ArrayList<T> getAll(Date begin, Date end) {
		Collection map = scheduler.subMap(begin, end).values();
		return new ArrayList<>(map);
	}

	T getFirst() {
		return scheduler.firstEntry().getValue();
	}

	T getLast() {
		return scheduler.lastEntry().getValue();
	}
}
