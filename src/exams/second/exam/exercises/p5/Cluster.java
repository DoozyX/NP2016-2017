package exams.second.exam.exercises.p5;

import java.util.*;
import java.util.stream.Collectors;

class Cluster<T extends Distance<T>> {
	private Map<Long, T> elements;

	public Cluster() {
		elements = new HashMap<>();
	}

	public void addItem(T element) {
		elements.put(element.getId(), element);
	}

	public void near(long id, int top) {
		T element = elements.get(id);
		elements.remove(id);
		List<T> near = elements.values().stream().sorted(Comparator.comparingDouble(o -> o.calculateDistance(element))).limit(top).collect(Collectors.toList());
		int i = 0;
		for (T e : near) {
			System.out.println(++i + ". " + e.getId() + " -> " + String.format("%.3f", e.calculateDistance(element)));
		}
	}
}
