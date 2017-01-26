package exams.second.exam.exercises.p2;

import java.util.*;

class PhoneBook {
	private Map<String, Set<Contact>> contactsByName;
	private Map<String, Set<Contact>> contactsByNumber;

	public PhoneBook() {
		contactsByName = new HashMap<>();
		contactsByNumber = new HashMap<>();
	}

	void addContact(String name, String number) throws DuplicateNumberException {
		if (!contactsByNumber.containsKey(number)) {
			Contact contact = new Contact(name, number);
			Set<Contact> contactSet = contactsByName.get(name);
			if (contactSet == null) {
				Set<Contact> contacts = new TreeSet<>();
				contacts.add(contact);
				contactsByName.put(name, contacts);
			} else {
				contactSet.add(new Contact(name, number));
			}

			List<String> numbers = contact.getSubnumber();
			addNumber(number,contact);
			for (String num : numbers) {
				addNumber(num,contact);
			}
		} else {
			throw new DuplicateNumberException(number);
		}
	}

	private void addNumber(String number, Contact contact) {
		Set<Contact> cont = contactsByNumber.get(number);
		if (cont == null) {
			Set<Contact> contacts = new TreeSet<>();
			contacts.add(contact);
			contactsByNumber.put(number, contacts);
		} else {
			cont.add(contact);
		}
	}

	void contactsByNumber(String number) {
		Set<Contact> contacts = contactsByNumber.get(number);
		if (contacts == null || contacts.size() == 0) {
			System.out.println("NOT FOUND");
		} else {
			for (Contact contact : contacts) {
				System.out.println(contact);
			}
		}
	}

	void contactsByName(String name) {
		Set<Contact> contacts = contactsByName.get(name);
		if (contacts == null || contacts.size() == 0) {
			System.out.println("NOT FOUND");
		} else {
			for (Contact contact : contacts) {
				System.out.println(contact);
			}
		}
	}
}
