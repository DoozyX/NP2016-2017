package labs.lab3.p1;

import java.util.ArrayList;
import java.util.List;

class PizzaItem implements Item {
	static List<Type> types = new ArrayList<>();
	static int nTypes = 0;
	private Type type;
	private int count;

	public PizzaItem(String type) throws InvalidPizzaTypeException {
		addTypes("Standard", 10);
		addTypes("Pepperoni", 12);
		addTypes("Vegetarian", 8);
		nTypes += 3;
		count = 1;
		for (Type aType : types) {
			if (aType.getName().equals(type)) {
				this.type = aType;
				return;
			}

		}
		throw new InvalidPizzaTypeException();
	}

	static void addTypes(String type, int price) {
		types.add(new Type(type, price));
		++nTypes;
	}

	public Type getType() {
		return type;
	}

	@Override
	public int getPrice() {
		for (Type aType : types) {
			if (aType.equals(type)) {
				return aType.getPrice() * count;
			}
		}
		return -1;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public void setCount(int count) {
		this.count = count;
	}

	private static class InvalidPizzaTypeException extends Exception {
		InvalidPizzaTypeException() {
			super("Not correct type.");
		}
	}
}
