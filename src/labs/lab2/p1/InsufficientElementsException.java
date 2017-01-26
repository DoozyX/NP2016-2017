package labs.lab2.p1;

class InsufficientElementsException extends Exception {
	public InsufficientElementsException() {
		super("Insufficient number of elements");
	}
}
