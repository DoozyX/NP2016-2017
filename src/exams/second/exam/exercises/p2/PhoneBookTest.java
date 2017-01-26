package exams.second.exam.exercises.p2;

import java.util.Scanner;


/**
 * Именик (35 поени) Problem 2
 * Да се имплементира класа за именик PhoneBook со следните методи:
 * <p>
 * void addContact(String name, String number) - додава нов контакт во именикот.
 * Ако се обидеме да додадеме контакт со веќе постоечки број, треба да се фрли исклучок од класа DuplicateNumberException со порака Duplicate number: [number].
 * Комплексноста на овој метод не треба да надминува O(logN) за N контакти.
 * void contactsByNumber(String number) - ги печати сите контакти кои во бројот го содржат бројот пренесен како аргумент во методот (минимална должина на бројот [number] е 3).
 * Комплексноста на овој метод не треба да надминува O(logN) за N контакти.
 * void contactsByName(String name) - ги печати сите контакти кои даденото име. Комплексноста на овој метод треба да биде O(1).
 * Во двата методи контактите се печатат сортирани лексикографски според името, а оние со исто име потоа според бројот.
 *
 * Sample input
 10
 Nicholas:071653488
 Joseph:077339727
 David:07732913
 Sophia:077959114
 Christopher:070556447
 Chloe:076481682
 Ashley:076522077
 Chloe:070332432
 Ethan:075278452
 Grace:078952211
 NUM:522
 NUM:0765
 NUM:0773
 NAME:Chloe
 NAME:Grace
 NUM:34444
 *
 * Sample output
 NUM:522
 Ashley 076522077
 Grace 078952211
 NUM:0765
 Ashley 076522077
 NUM:0773
 David 07732913
 Joseph 077339727
 NAME:Chloe
 Chloe 070332432
 Chloe 076481682
 NAME:Grace
 Grace 078952211
 NUM:34444
 NOT FOUND
 */

public class PhoneBookTest {

	public static void main(String[] args) {
		PhoneBook phoneBook = new PhoneBook();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < n; ++i) {
			String line = scanner.nextLine();
			String[] parts = line.split(":");
			try {
				phoneBook.addContact(parts[0], parts[1]);
			} catch (DuplicateNumberException e) {
				System.out.println(e.getMessage());
			}
		}
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			System.out.println(line);
			String[] parts = line.split(":");
			if (parts[0].equals("NUM")) {
				phoneBook.contactsByNumber(parts[1]);
			} else {
				phoneBook.contactsByName(parts[1]);
			}
		}
	}

}
