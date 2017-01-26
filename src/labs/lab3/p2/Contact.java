package labs.lab3.p2;


import java.util.Arrays;


class Contact implements Comparable<Contact> {
	private static String[] OPERATORS_PREFIX = {"070", "071", "072", "075", "076", "077", "078"};
	private static int MAX_CONTACTS = 5;
	private String name;
	private String[] phoneNumber;
	private int nPhones;

	public Contact(String name, String... phoneNumbers) throws Exception {
		if (name.matches("^[a-zA-Z0-9]*$") && name.length() >= 4 && name.length() <= 10) {
			this.name = name;
		} else {
			throw new InvalidNameException(name);
		}
		this.nPhones = phoneNumbers.length;
		phoneNumber = new String[MAX_CONTACTS];
		if (nPhones > MAX_CONTACTS) {
			throw new MaximumSizeExceddedException();
		}
		int i = 0;
		for (String phone : phoneNumbers) {
			checkNumber(phone);
			phoneNumber[i++] = phone;

		}
	}

	public static void checkNumber(String phone) throws InvalidNumberException {
		boolean ok = false;
		for (String prefix : OPERATORS_PREFIX) {
			if (phone.substring(0, 3).equals(prefix) && phone.matches("[0-9]+") && phone.length() == 9) {
				ok = true;
				break;
			}
		}
		if (!ok) {
			throw new InvalidNumberException();
		}
	}

	public static Contact valueOf(String s) throws InvalidFormatException {
		try {
			String[] contact = s.split("\\s+");
			String[] phones = Arrays.copyOfRange(contact, 1, contact.length);
			return new Contact(contact[0], phones);
		} catch (Exception e) {
			throw new InvalidFormatException();
		}
	}

	public String getName() {
		return name;
	}

	public String[] getNumbers() {
		String[] temp = Arrays.copyOf(phoneNumber, nPhones);
		Arrays.sort(temp);
		return temp;
	}

	public void addNumber(String phone) throws Exception {
		checkNumber(phone);
		if (nPhones < 5) {
			phoneNumber[nPhones++] = phone;
		} else {
			throw new MaximumSizeExceddedException();
		}
	}

	@Override
	public String toString() {
		String sb = name + '\n' +
				+nPhones + '\n';
		for (String phone : getNumbers()) {
			sb += phone + '\n';
		}
		return sb;
	}

	@Override
	public int compareTo(Contact c) {
		return name.compareTo(c.name);
	}

	public String toLine() {
		String sb = name + " ";
		for (String phone : getNumbers()) {
			sb += phone + ' ';
		}
		return sb;
	}
}