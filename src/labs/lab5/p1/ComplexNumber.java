package labs.lab5.p1;

class ComplexNumber<T extends Number, U extends Number> implements Comparable<ComplexNumber<?, ?>> {
	private T real;
	private U imaginary;

	public ComplexNumber(T real, U imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	T getReal() {
		return real;
	}

	U getImaginary() {
		return imaginary;
	}

	double modul() {
		double r = real.doubleValue();
		double i = imaginary.doubleValue();
		return Math.sqrt(r * r + i * i);
	}

	@Override
	public int compareTo(ComplexNumber<?, ?> o) {
		if (modul() == o.modul()) {
			return 0;
		} else if (modul() > o.modul()) {
			return 1;
		}
		return -1;
	}

	@Override
	public String toString() {
		if (imaginary.doubleValue() >= 0) {
			return String.format("%.02f+%.02fi", real.doubleValue(), imaginary.doubleValue());
		} else {
			return String.format("%.02f%.02fi", real.doubleValue(), imaginary.doubleValue());
		}
	}
}
