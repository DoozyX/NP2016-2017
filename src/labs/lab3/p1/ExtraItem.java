package labs.lab3.p1;

import java.util.ArrayList;
import java.util.List;

class ExtraItem implements Item {
	private static List<Type> types = new ArrayList<>();
	private static int nTypes = 0;
	private Type type;
	private int count;

	public ExtraItem(String type) throws InvalidExtraTypeException {
		addTypes("Coke", 5);
		addTypes("Ketchup", 3);
		nTypes += 2;
		count = 1;
		for (Type aType : types) {
			if (aType.getName().equals(type)) {
				this.type = aType;
				return;
			}

		}
		throw new InvalidExtraTypeException();
	}

	static void addTypes(String type, int price) {
		types.add(new Type(type, price));
		++nTypes;
	}

	public Type getType() {
		return type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	private static class InvalidExtraTypeException extends Exception {
		InvalidExtraTypeException() {
			super("Not correct type.");
		}
	}
}
