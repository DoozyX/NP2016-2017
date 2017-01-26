package labs.lab6.p1;

import java.util.Scanner;

/**
 * Супер-стринг Problem 1
 * Треба да се напише класа SuperString. Класата во позадина претставува листа на стрингови LinkedList<String> и ги нуди следните методи:
 * <p>
 * SuperString() - креира празен стринг
 * append(String s) - го додава стрингот на крајот во листата
 * insert(String s) - го додава стрингот на почеток на листата
 * contains(String s):boolean - враќа true доколку стрингот s се наоѓа во супер-стрингот. Стрингот s може да е разделен во повеќе подстрингови во листата.
 * Пр: list = [ "st" , "arz" , "andrej" ] , contains("tarzan") –> true
 * reverse() - го превртува стрингот на следниов начин. Ги превртува сите елементи во листата, а потоа и секој подстринг како елемент посебно го превртува.
 * list = [ "st" , "arz" , "andrej: ]; reverse(); list = [ "jerdna", "zra", "ts"]
 * toString():String - ги враќа конкатенирани сите елементи во листата list = [ "st" , "arz" , "andrej"]; toString() -> "starzandrej"
 * removeLast(int k) – ги отстранува последнo додадените k подстрингови
 * <p>
 * Sample input
 * 0
 * 1 ej`
 * 0 Gaj
 * 1 r
 * 0 du
 * 1 d
 * 1 n
 * 1 A
 * 0 K
 * 2 aj
 * 2 Gaj
 * 2 Gajd
 * 2 Gajdu
 * 2 GajduK
 * 2 Gajduk
 * 2 Gajdur
 * 2 Gajdun
 * 2 ej`GajrdudnAK
 * 2 An
 * 2 Kassandra
 * 2 dnA
 * 2 Kand
 * 2 ejGaj
 * 2 Andrej`GajduK
 * 6
 * <p>
 * Sample output
 * true
 * true
 * true
 * true
 * true
 * false
 * false
 * false
 * false
 * true
 * false
 * false
 * false
 * false
 * true
 */

public class SuperStringTest {
	public static void main(String[] args) {
		Scanner jin = new Scanner(System.in);
		int k = jin.nextInt();
		if (k == 0) {
			SuperString s = new SuperString();
			while (true) {
				int command = jin.nextInt();
				if (command == 0) {//append(String s)
					s.append(jin.next());
				}
				if (command == 1) {//insert(String s)
					s.insert(jin.next());
				}
				if (command == 2) {//contains(String s)
					System.out.println(s.contains(jin.next()));
				}
				if (command == 3) {//reverse()
					s.reverse();
				}
				if (command == 4) {//toString()
					System.out.println(s);
				}
				if (command == 5) {//removeLast(int k)
					s.removeLast(jin.nextInt());
				}
				if (command == 6) {//end
					break;
				}
			}
		}
	}

}

