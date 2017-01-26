package labs.lab7.p2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Сортирана двојно поврзана листа Problem 2
 * Треба да се развие класа SortedLinkedList која претставува генеричка двојно поврзана листа.
 * Листата треба постојано да се одржува сортирана (ова повлекува дека елементите во листата треба да може да се споредуваат).
 * <p>
 * SortedLinkedList() - креира нова празна листа
 * add(T element) - го додава елементот во листата (се запазува подреденоста на елементите. Ако елементот веќе го има во листата не треба да се додава).
 * contains(T element):boolean - враќа true, ако елементот е присутен во листата
 * remove(T element):boolean - ако елементот го има во листата го отстранува и враќа true, во спротивно враќа false;
 * isEmpty():boolean - враќа true ако листата е празна (не содржи ниту еден елемент)
 * size():int - го враќа бројот на елементи во листата
 * toArrayList():ArrayList<T> - ја враќа листата како ArrayList објект, притоа елементите треба да се во ист редослед како во листата (сортирани)
 * addAll(SortedLinkedList<? extends T> a) - ги додава сите елементи од а во листата. Ова може да се имплементира со помош на:
 * <p>
 * iterate over all elements in a
 * <p>
 * this.add(element);
 * <p>
 * Размислете како би можело да се имплементира поефикасно.
 * <p>
 * containsAll(SortedLinkedList<? extends T> а):boolean - ако листата ги содржи сите елементи кои ги има во a враќа true, инаку враќа false. Важи истата забелешка како и за претходниот метод.
 * ЗА РЕШАВАЊЕ НА ЗАДАЧАТА НЕ СМЕЕ ДА СЕ КОРИСТИ LinkedList или ArraysList
 * <p>
 * Sample input
 * 1 23 45 78 95 15512 541545485 955855415
 * <p>
 * Sample output
 * Test#1
 * testing SortedLinkedList::toArrayList():ArrayList<T> , SortedLinkedList::add(T) , T is Integer
 * Adding elements:
 * 23 45 78 95 15512 541545485 955855415
 * Final list: [23, 45, 78, 95, 15512, 541545485, 955855415]
 */

public class SortedLinkedListTest {
	public static void main(String[] args) {
		Scanner jin = new Scanner(System.in);
		int k = jin.nextInt();
		System.out.println("Test#" + k);
		System.out.print("testing SortedLinkedList::toArrayList():ArrayList<T> ,");
		if (k == 0) {
			System.out.println(" SortedLinkedList::add(T), SortedLinkedList::isEmpty():boolean , SortedLinkedList::remove(T):boolean , SortedLinkedList::size():int , T is Integer");

			SortedLinkedList<Integer> list = new SortedLinkedList<>();
			System.out.println("List is empty? " + list.isEmpty());
			System.out.println("Adding elements:");
			boolean flag = false;
			while (jin.hasNextInt()) {
				System.out.print(flag ? " " : "");
				int i = jin.nextInt();
				list.add(i);
				System.out.print(i);
				flag = true;
			}
			System.out.println();
			System.out.println("List size? " + list.size());
			jin.next();
			flag = false;
			System.out.println();
			System.out.print("Final list: ");
			System.out.println(list.toArrayList());
			System.out.println("Removing elements:");
			while (jin.hasNextInt()) {
				System.out.print(flag ? " " : "");
				int i = jin.nextInt();
				list.remove(i);
				System.out.print(i);
				flag = true;
			}
			System.out.println();
			System.out.println("List size? " + list.size());
			System.out.println("Final list: " + list.toArrayList());
		}
		if (k == 1) {
			System.out.println(" SortedLinkedList::add(T) , T is Integer");
			System.out.println("Adding elements:");
			SortedLinkedList<Integer> list = new SortedLinkedList<Integer>();
			boolean flag = false;
			while (jin.hasNextInt()) {
				System.out.print(flag ? " " : "");
				int i = jin.nextInt();
				list.add(i);
				System.out.print(i);
				flag = true;
			}
			System.out.println();
			System.out.print("Final list: ");
			System.out.println(list.toArrayList());
		}
		if (k == 2) {
			System.out.println(" SortedLinkedList::add(T) , SortedLinkedList::addAll(SortedLinkedList<? etends T>) , T is Integer");

			int num_testcases = jin.nextInt();
			for (int w = 0; w < num_testcases; ++w) {
				System.out.println("Subtest #" + (w + 1));
				SortedLinkedList<Integer> list = new SortedLinkedList<Integer>();
				while (jin.hasNextInt()) {
					list.add(jin.nextInt());
				}
				SortedLinkedList<Integer> query = new SortedLinkedList<Integer>();
				jin.next();
				while (jin.hasNextInt()) {
					query.add(jin.nextInt());
				}
				System.out.println("List a=" + list.toArrayList());
				System.out.println("List b=" + query.toArrayList());
				list.addAll(query);
				System.out.println("Add all elements from b to a");
				System.out.println("List a=" + list.toArrayList());
				jin.next();
			}
		}
		if (k == 3) {
			System.out.println(" SortedLinkedList::add(T) , SortedLinkedList::containsAll(SortedLinkedList<? etends T>) , T is Integer");
			int num_testcases = jin.nextInt();
			for (int w = 0; w < num_testcases; ++w) {
				System.out.println("Subtest #" + (w + 1));
				SortedLinkedList<Integer> list = new SortedLinkedList<>();
				while (jin.hasNextInt()) {
					list.add(jin.nextInt());
				}
				SortedLinkedList<Integer> query = new SortedLinkedList<>();
				jin.next();
				while (jin.hasNextInt()) {
					query.add(jin.nextInt());
				}
				System.out.println("List a=" + list.toArrayList());
				System.out.println("List b=" + query.toArrayList());
				System.out.println("List a contains all elements in list b? " + list.containsAll(query));
				jin.next();
			}
		}
		if (k == 4) {
			System.out.println(" SortedLinkedList::add(T) , SortedLinkedList::remove(T):boolean , SortedLinkedList::contains(T) , T is String");
			SortedLinkedList<String> list = new SortedLinkedList<>();
			TreeSet<String> control_list = new TreeSet<>();
			ArrayList<String> all = new ArrayList<>();
			all.add("Sample");
			boolean same = true;
			for (int i = 0; i < 10; ++i) {
				double rand = Math.random();
				if (rand > 0.3) { //add element
					String srand = randomString();
					if (Math.random() < 0.1) {
						srand = all.get((int) (Math.random() * all.size()));
					}
					control_list.add(srand);
					list.add(srand);
				}
				if (rand >= 0.3 && rand < 0.8) {//query
					String srand = randomString();
					if (Math.random() < 0.6) {
						srand = all.get((int) (Math.random() * all.size()));
					}
					System.out.println(control_list);
					System.out.println("[" + list + "]");
					System.out.println();
					same &= control_list.contains(srand) == list.contains(srand);
				}
				if (rand >= 0.8) {//remove
					String srand = randomString();
					if (Math.random() < 0.8) {
						srand = all.get((int) (Math.random() * all.size()));
					}
					control_list.remove(srand);
					list.remove(srand);
				}
			}
			System.out.println("Your list outputs compared to the built in java structure were the same? " + same);

		}
		if (k == 5) {
			System.out.println(" SortedLinkedList::add(T) , SortedLinkedList::remove(T):boolean , T is Long");
			int n = jin.nextInt();
			SortedLinkedList<Long> list = new SortedLinkedList<Long>();
			ArrayList<Long> all = new ArrayList<Long>();
			all.add(684165189745L);
			for (int i = 0; i < n; ++i) {
				double rand = Math.random();
				if (rand < 0.7) { //addelement
					Long srand = (long) (Math.random() * 45668948941984L);
					if (Math.random() < 0.1) {
						srand = all.get((int) (Math.random() * all.size()));
					}
					list.add(srand);
				}
				if (rand >= 0.7) {
					Long srand = (long) (Math.random() * 45668948941984L);
					if (Math.random() < 0.1) {
						srand = all.get((int) (Math.random() * all.size()));
					}
					list.remove(srand);
				}
			}
			System.out.println("Your program was really fast. You are a great developer!");
		}
	}

	private static String randomString() {
		byte buf[] = new byte[(int) (Math.random() * 10) + 1];
		new Random().nextBytes(buf);
		return new String(buf);
	}

}

