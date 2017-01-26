package exams.second.exam.exercises.p3;

import java.util.*;
import java.util.stream.Collectors;

class BlockContainer<T extends Comparable<T>> {
	private List<Set<T>> blocks;
	private int size;

	public BlockContainer(int n) {
		blocks = new ArrayList<>();
		this.size = n;
	}

	public void add(T a) {
		int n = blocks.size();
		if (n == 0) {
			Set<T> block = new TreeSet<>();
			block.add(a);
			blocks.add(block);
		} else {
			Set<T> lastBlock = blocks.get(n - 1);
			if (lastBlock.size() == size) {
				Set<T> block = new TreeSet<>();
				block.add(a);
				blocks.add(block);
			} else {
				lastBlock.add(a);
			}
		}
	}

	public boolean remove(T a) {
		int n = blocks.size();
		Set<T> lastBlock = blocks.get(n - 1);
		lastBlock.remove(a);
		if (lastBlock.size() == 0) {
			blocks.remove(n - 1);
		}
		return true;
	}

	public void sort() {
		List<T> allBlocks = new ArrayList<>();
		for (Set<T> set: blocks) {
			allBlocks.addAll(set);
		}
		allBlocks = allBlocks.stream().sorted().collect(Collectors.toList());
		blocks = new ArrayList<Set<T>>();
		for (T element : allBlocks) {
			add(element);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Set<T> set : blocks) {
			sb.append(set.toString()).append(",");
		}
		sb.setLength(sb.length()-1);
		return sb.toString();
	}
}

