package labs.lab3.p1;

import java.util.ArrayList;
import java.util.List;

class Order {
	int nItems;
	boolean locked;
	private List<Item> items;

	public Order() {
		this.nItems = 0;
		this.items = new ArrayList<>();
		this.locked = false;
	}

	public void addItem(Item item, int count) throws ItemOutOfStockException, OrderLockedException {
		if (locked) {
			throw new OrderLockedException();
		}
		if (count > 10) {
			throw new ItemOutOfStockException();
		}
		boolean dontExist = true;
		for (Item anItem : items) {
			if (anItem.getType().equals(item.getType())) {
				anItem.setCount(count);
				dontExist = false;
			}
		}
		if (dontExist) {
			item.setCount(count);
			items.add(item);
			++nItems;
		}
	}

	public int getPrice() {
		int sum = 0;
		for (Item anItem : items) {
			sum += anItem.getPrice();
		}
		return sum;
	}

	public void displayOrder() {
		for (int i = 0; i < nItems; ++i) {
			System.out.println(String.format("%3d.%-15sx%2d%5d$", i + 1, items.get(i).getType().getName(), items.get(i).getCount(), items.get(i).getPrice()));
		}
		System.out.println(String.format("Total:%21d$ ", this.getPrice()));
	}

	public void removeItem(int idx) throws OrderLockedException, ArrayIndexOutOfBоundsException {
		if (locked) {
			throw new OrderLockedException();
		}
		if (items.get(idx) == null) {
			throw new ArrayIndexOutOfBоundsException(idx);
		}
		items.remove(idx);
		--nItems;
	}

	public void lock() throws EmptyOrder {
		if (nItems < 1) {
			throw new EmptyOrder();
		}
		locked = true;
	}

	private class ArrayIndexOutOfBоundsException extends Exception {
		ArrayIndexOutOfBоundsException(int id) {
			super("Item with index " + id + " doesn't exist.");
		}
	}

	private class EmptyOrder extends Exception {
		EmptyOrder() {
			super("Order is empty.");
		}
	}

	private class ItemOutOfStockException extends Exception {
		ItemOutOfStockException() {
			super("Item is out of stock.");
		}
	}

	private class OrderLockedException extends Exception {
		OrderLockedException() {
			super("Order is locked.");
		}
	}
}
