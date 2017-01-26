package labs.lab2.p2;

abstract class Contact {
	//creation date
	private int year;
	private int month;
	private int day;

	public Contact(String date) {
		String[] dates = date.split("-");
		year = Integer.parseInt(dates[0]);
		month = Integer.parseInt(dates[1]);
		day = Integer.parseInt(dates[2]);
	}

	public Contact() {
		year = 0;
		month = 0;
		day = 0;
	}

	public boolean isNewerThan(Contact c) {
		if (year > c.year) {
			return true;
		}
		if (year < c.year) {
			return false;
		}
		if (month > c.month) {
			return true;
		}
		if (month < c.month) {
			return false;
		}
		return day > c.day;

	}

	public abstract String getType();
}
