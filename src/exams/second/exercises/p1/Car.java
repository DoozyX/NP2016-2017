package exams.second.exercises.p1;

class Car {
	private String manufacturer;
	private String model;
	private int price;
	private float power;

	public Car(String manufacturer, String model, int price, float power) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.price = price;
		this.power = power;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getModel() {
		return model;
	}

	public int getPrice() {
		return price;
	}

	public float getPower() {
		return power;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(manufacturer).append(" ").append(model).append(" (").append(String.format("%dKW",(int)power)).append(") ").append(price);
		return sb. toString();
	}
}
