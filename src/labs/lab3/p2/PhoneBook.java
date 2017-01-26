package labs.lab3.p2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


class PhoneBook {
	static int MAX_CONTACTS = 250;
	private Contact[] contacts;
	private int nContacts;


	PhoneBook() {
		nContacts = 0;
		contacts = new Contact[MAX_CONTACTS];
	}

	static boolean saveAsTextFile(PhoneBook phonebook, String path) {
		try {
			PrintWriter writer = new PrintWriter(path);
			writer.print(phonebook.toLines());
			writer.close();
			return true;
		} catch (Exception e) {
			// do something
			return false;
		}
	}

	static PhoneBook loadFromTextFile(String path) throws Exception {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			PhoneBook pb = new PhoneBook();
			String line;
			while ((line = br.readLine()) != null) {
				// process the line.
				try {
					pb.addContact(Contact.valueOf(line));
				} catch (InvalidFormatException e) {
					throw new InvalidFormatException();
				}
			}
			return pb;
		} catch (IOException e) {
			throw new IOException();
		}
	}

	void addContact(Contact contact) throws Exception {
		if (nContacts < MAX_CONTACTS) {
			for (int i = 0; i < nContacts; i++) {
				if (contacts[i].getName().equals(contact.getName())) {
					throw new InvalidNameException(contacts[i].getName());
				}
			}
			contacts[nContacts++] = contact;
		} else {
			throw new MaximumSizeExceddedException();
		}
	}

	Contact getContactForName(String name) {
		for (int i = 0; i < nContacts; i++) {
			if (contacts[i].getName().equals(name)) {
				return contacts[i];
			}
		}
		return null;
	}

	int numberOfContacts() {
		return nContacts;
	}

	Contact[] getContacts() {
		Contact[] temp = Arrays.copyOf(contacts, nContacts);
		Arrays.sort(temp);
		return temp;
	}

	boolean removeContact(String name) {
		for (int i = 0; i < nContacts; i++) {
			if (contacts[i].getName().equals(name)) {
				System.arraycopy(contacts, i + 1, contacts, i, nContacts - 1 - i);
				--nContacts;
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String sb = "";
		for (int i = 0; i < nContacts; i++) {
			sb += getContacts()[i].toString() + '\n';
		}
		return sb;
	}

	String toLines() {
		String sb = "";
		for (int i = 0; i < nContacts; i++) {
			sb += contacts[i].toLine() + '\n';
		}
		return sb;
	}

	Contact[] getContactsForNumber(String numberPrefix) {
		Contact[] temp = new Contact[nContacts];
		int i = 0;
		for (Contact c : getContacts()) {
			String[] numbers = c.getNumbers();
			for (String num : numbers) {
				if (num.substring(0, 3).equals(numberPrefix)) {
					temp[i++] = c;
					break;
				}
			}
		}
		return Arrays.copyOf(temp, i);
	}
}
