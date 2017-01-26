package labs.lab2.p2;

class EmailContact extends Contact {
	private String email;

	public EmailContact(String date, String email) {
		super(date);
		this.email = email;
	}

	public EmailContact() {
		super();
		this.email = "Unknown";
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getType() {
		return "Email";
	}

	@Override
	public String toString() {
		return "\"" + email + "\"";
	}
}
