package labs.lab2.p2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Student {
	private String firstName;
	private String lastName;
	private String city;
	private int age;
	private long index;
	private List<Contact> contacts;
	private int contactsN;
	private int emailContactsN;
	private int phoneContactsN;

	public Student(String firstName, String lastName, String city, int age, long index) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.age = age;
		this.index = index;
		this.contacts = new ArrayList<>();
		this.contactsN = 0;
		this.emailContactsN = 0;
		this.phoneContactsN = 0;
	}

	public void addEmailContact(String date, String email) {
		Contact c = new EmailContact(date, email);
		contacts.add(c);
		++contactsN;
	}

	public void addPhoneContact(String date, String phone) {
		Contact c = new PhoneContact(date, phone);
		contacts.add(c);
		++contactsN;
	}

	public Contact[] getEmailContacts() {
		List<Contact> emails = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < contactsN; ++i) {
			if (contacts.get(i).getType().equals("Email")) {
				emails.add(contacts.get(i));
				++count;
			}
		}
		this.emailContactsN = count;
		Contact[] emailsArr = new Contact[emailContactsN];
		emailsArr = emails.toArray(emailsArr);
		return emailsArr;
	}

	public Contact[] getPhoneContacts() {
		List<Contact> phones = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < contactsN; ++i) {
			if (contacts.get(i).getType().equals("Phone")) {
				phones.add(contacts.get(i));
				++count;
			}
		}
		this.phoneContactsN = count;
		Contact[] phonesArr = new Contact[phoneContactsN];
		phonesArr = phones.toArray(phonesArr);
		return phonesArr;
	}

	public int getEmailContactsN() {
		return emailContactsN;
	}

	public int getPhoneContactsN() {
		return phoneContactsN;
	}

	public int getContactsN() {
		return contactsN;
	}

	public String getCity() {
		return city;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public long getIndex() {
		return index;
	}

	public Contact getLatestContact() {
		Contact newest = contacts.get(0);
		for (int i = 1; i < contacts.size(); ++i) {
			if (contacts.get(i).isNewerThan(newest)) {
				newest = contacts.get(i);
			}
		}
		return newest;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("{");
		sb.append("\"ime\":\"").append(firstName).append('\"');
		sb.append(", \"prezime\":\"").append(lastName).append('\"');
		sb.append(", \"vozrast\":").append(age);
		sb.append(", \"grad\":\"").append(city).append('\"');
		sb.append(", \"indeks\":").append(index);
		sb.append(", \"telefonskiKontakti\":").append(Arrays.toString(getPhoneContacts()));
		sb.append(", \"emailKontakti\":").append(Arrays.toString(getEmailContacts()));
		sb.append('}');
		return sb.toString();
	}
}
