package labs.lab7.p4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 Бинарно дрво за пребарување Problem 4
 Треба да се развие класа BinaryTreeSet за едноставно генеричко бинарно дрво за пребарување. Дрвото треба да ги има следните методи:

 BinaryTreeSet() - креира ново празно бинарно дрво
 addElement(T element) - додава нов елемент во дрвото. Не се чуваат дупликати.
 contains(T element):boolean - враќа true доколку дрвото го содржи дадениот елемент.
 removeElement(T element):boolean - доколку елементот го има во дрвотo го остранува и враќа true, инаку враќа false
 (немора бришењто физички да го отстранува елементот од дрвото, може да имплементирате т.н. мрзливо бришење, на тој начин што ќе поставите некој маркер кој кажува дека јазелот е избришан).
 toString():String - враќа стринг во кои се содржат сите елементи во дрвото одделени со едно празно место.
 Елементите треба да се во редослед онака како што се добиваат со inorder изминување на дрвото. Доколку дрвото е празно (не содржи ниеден елемент) враќа "EMPTY" (наводниците се само за појаснување).

 Sample input
 0 1 2 3 2 2 2 2 2 stop

 Sample output
 1 2 3
 */

public class BinaryTreeSetTest {

	public static void main(String[] args) {
		Scanner jin = new Scanner(System.in);
		int t = jin.nextInt();
		if ( t == 0 ) {
			BinaryTreeSet<Integer> ts = new BinaryTreeSet<Integer>();
			while ( jin.hasNextInt() ) {
				ts.addElement(jin.nextInt());
			}
			System.out.println(ts);
		}
		if ( t == 1 ) {
			BinaryTreeSet<String> ts = new BinaryTreeSet<String>();
			while ( true ) {
				String next = jin.next();
				if ( next.equals("stop") ) break;
				ts.addElement(next);
			}
			System.out.println(ts);
		}
		if ( t == 2 ) {
			BinaryTreeSet<Long> ts = new BinaryTreeSet<Long>();
			while ( jin.hasNextLong() ) {
				ts.addElement(jin.nextLong());
			}
			jin.next();
			System.out.println(ts);
			while ( jin.hasNextLong() ) {
				System.out.println(ts.contains(jin.nextLong()));
			}
			System.out.println(ts);
		}
		if ( t == 3 ) {
			BinaryTreeSet<String> ts = new BinaryTreeSet<String>();
			int counter = 0;
			while ( true ) {
				if ( counter % 20 == 0 ) System.out.println(ts);
				++counter;
				String next = jin.next();
				if ( next.equals("stop") ) break;
				if ( next.equals("add") ) {
					ts.addElement(jin.next());
				}
				if ( next.equals("remove") ) {
					ts.removeElement(jin.next());
				}
				if ( next.equals("query") ) {
					System.out.println(ts.contains(jin.next()));
				}
			}
			System.out.println(ts);
		}
		if ( t == 4 ) {
			BinaryTreeSet<Long> ts = new BinaryTreeSet<Long>();
			TreeSet<Long> control_set = new TreeSet<Long>();
			ArrayList<Long> all = new ArrayList<Long>();
			all.add(5L);
			int n = jin.nextInt();
			boolean exact = true;
			for ( int i = 0 ; exact&&i < n ; ++i ) {
				if ( Math.random() < 0.4 ) {
					if ( Math.random() < 0.6 ) {
						long to_add = (long)(Math.random()*98746516548964156L);
						ts.addElement(to_add);
						control_set.add(to_add);
						all.add(to_add);
					}
					else {
						int add_idx = (int)(Math.random()*all.size());
						long to_add = all.get(add_idx);
						ts.addElement(to_add);
						control_set.add(to_add);
					}
				}
				else {
					if ( Math.random() < 0.4 ) {
						if ( Math.random() < 0.1 ) {
							long to_remove = (long)(Math.random()*98746516548964156L);
							ts.removeElement(to_remove);
							control_set.remove(to_remove);
						}
						else {
							int remove_idx = (int)(Math.random()*all.size());
							long to_remove = all.get(remove_idx);
							ts.removeElement(to_remove);
							control_set.remove(to_remove);
						}
					}
					else {
						if ( Math.random() < 0.3 ) {
							long to_query = (long)(Math.random()*98746516548964156L);
							exact &= ts.contains(to_query)==control_set.contains(to_query);
						}
						else {
							int query_idx = (int)(Math.random()*all.size());
							long to_query = all.get(query_idx);
							exact &= ts.contains(to_query)==control_set.contains(to_query);
						}
					}
				}
			}
			System.out.println(exact);
		}
	}

}
