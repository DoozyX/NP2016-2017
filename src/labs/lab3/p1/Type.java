package labs.lab3.p1;

class Type {
	private String name;
	private int price;

	public Type(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public Type() {
		this("Unknown", 0);
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}
