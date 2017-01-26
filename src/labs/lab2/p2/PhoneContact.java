package labs.lab2.p2;

class PhoneContact extends Contact {
	private String phone;

	public PhoneContact(String date, String phone) {
		super(date);
		this.phone = phone;
	}

	public PhoneContact() {
		super();
		this.phone = "000/000-000";
	}

	public String getPhone() {
		return phone;
	}

	public Operator getOperator() {
		String[] operator = phone.split("/");
		int operatorDigit = Integer.parseInt(operator[0]) % 10;
		if (operatorDigit == 0 || operatorDigit == 1 || operatorDigit == 2) {
			return Operator.TMOBILE;
		}
		if (operatorDigit == 5 || operatorDigit == 6) {
			return Operator.ONE;
		}
		if (operatorDigit == 7 || operatorDigit == 8) {
			return Operator.VIP;
		}
		return null;
	}

	@Override
	public String getType() {
		return "Phone";
	}

	@Override
	public String toString() {
		return "\"" + phone + "\"";
	}

	enum Operator {VIP, ONE, TMOBILE}
}
