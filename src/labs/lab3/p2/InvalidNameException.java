package labs.lab3.p2;

class InvalidNameException extends Exception {
	public String name;

	public InvalidNameException(String message) {
		name = message;
	}
}

