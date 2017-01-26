package labs.lab3.p1;

import java.util.Scanner;

/**
 * Пицерија Problem 1
 * Треба да се развие систем за електронска нарачка од пицерија. Менито на пицеријата се состои од следново:
 * <p>
 * Pizza:
 * <p>
 * Standard: 10$
 * Pepperoni: 12$
 * Vegetarian: 8$
 * Extra
 * <p>
 * Ketchup 3$
 * Coke 5$
 * За да го претставите менито, секоја ставка треба да имплементира interface Item која опишува една ставка од менито и ги дефинира следниве методи:
 * <p>
 * getPrice():int - ја дава цената за конкретната ставка
 * Следно, дефинирајте две класи ExtraItem и PizzaItem за да може да правите разлика меѓу пици и останатите работи во нарачката. И двете класи треба да имаат еден конструктор кој прима еден String аргумент.
 * <p>
 * ExtraItem(String type) - валидни вредности за type се { "Coke", "Ketchup" }
 * PizzaItem(String type) - валидни вредности за type се { Standard , Pepperoni , Vegetarian }
 * Ако за type се проследи некоја невалидна вредност (која ја нема на менито) треба да се фрли исклучок InvalidExtraTypeException, односно InvalidPizzaTypeException.
 * <p>
 * Последно имплементирајте ја класата Order. Таа треба да ги нуди следните функционалности:
 * <p>
 * Order() - креира нова празна нарачка
 * addItem(Item item, int count) - соодветната ставка се додава во нарачката (count означува колку примероци сакаме од дадената ставка). Aко count е поголем од 10 се фрла исклучок ItemOutOfStockException(item).
 * Доколку во нарачката веќе ја има соодветната ставка Item тогаш истата се заменува со нова. Следниот код резултира со нарачка со една стандардна пица:
 * <p>
 * Order order = new Order(); order.addItem(new PizzaItem("Standard"), 2); order.addItem(new PizzaItem("Standard"), 1);
 * <p>
 * getPrice():int - ја враќа вкупната цена на нарачката
 * <p>
 * displayOrder() - ја печати содржината на нарачката со соодветни редни броеви пред секоја ставка, името, количината и збирна сума на ставката, како и вкупна сума за целата нарачка.
 * За редниот број се резервирани 3 места порамнети во десно, за имињата на ставките се резервирани 15 места со порамнување од лево,
 * за кардиналноста две места порамнети во десно и за цената на една ставка 5 места порамнети во десно. За "Total:" се резервирани 22 места со порамнување од лево и за вкупната цена 5 места порамнети во десно.
 * Пример:
 * 1.Standard       x 2   20$
 * 2.Vegetarian     x 1    8$
 * 3.Coke           x 3   15$
 * Total:                   43$
 * Редоследот по кој се печатат ставките е оној по кој тие се внесувани во нарачката. Доколку некоја ставка се внесе повторно нејзиното место не се менува.
 * <p>
 * removeItem(int idx) - се отстранува нарачката со даден индекс (сите нарачки со поголеми индекси се поместуваат во лево).
 * Доколку не постои нарачка со таков индекс треба да се фрли исклучок ArrayIndexOutOfBоundsException(idx)
 * lock() - ја заклучува нарачката. За да може нарачката да се заклучи треба истата да има барем една ставка, во спротивно фрлете исклучок EmptyOrderException.
 * Откако ќе се заклучи нарачката треба веќе да не може да се менува со методите removeItem, addItem. Повикот на овие методи резултира со исклучок од типот OrderLockedException.
 * <p>
 * Sample input
 * 0 Extra Ketchup
 * <p>
 * Sample output
 * 3
 */

public class PizzaOrderTest {
	public static void main(String[] args) {
		Scanner jin = new Scanner(System.in);
		int k = jin.nextInt();
		if (k == 0) { //test Item
			try {
				String type = jin.next();
				String name = jin.next();
				Item item = null;
				if (type.equals("Pizza")) item = new PizzaItem(name);
				else item = new ExtraItem(name);
				System.out.println(item.getPrice());
			} catch (Exception e) {
				System.out.println(e.getClass().getSimpleName());
			}
		}
		if (k == 1) { // test simple order
			Order order = new Order();
			while (true) {
				try {
					String type = jin.next();
					String name = jin.next();
					Item item = null;
					if (type.equals("Pizza")) item = new PizzaItem(name);
					else item = new ExtraItem(name);
					if (!jin.hasNextInt()) break;
					order.addItem(item, jin.nextInt());
				} catch (Exception e) {
					System.out.println(e.getClass().getSimpleName());
				}
			}
			jin.next();
			System.out.println(order.getPrice());
			order.displayOrder();
			while (true) {
				try {
					String type = jin.next();
					String name = jin.next();
					Item item = null;
					if (type.equals("Pizza")) item = new PizzaItem(name);
					else item = new ExtraItem(name);
					if (!jin.hasNextInt()) break;
					order.addItem(item, jin.nextInt());
				} catch (Exception e) {
					System.out.println(e.getClass().getSimpleName());
				}
			}
			System.out.println(order.getPrice());
			order.displayOrder();
		}
		if (k == 2) { // test order with removing
			Order order = new Order();
			while (true) {
				try {
					String type = jin.next();
					String name = jin.next();
					Item item = null;
					if (type.equals("Pizza")) item = new PizzaItem(name);
					else item = new ExtraItem(name);
					if (!jin.hasNextInt()) break;
					order.addItem(item, jin.nextInt());
				} catch (Exception e) {
					System.out.println(e.getClass().getSimpleName());
				}
			}
			jin.next();
			System.out.println(order.getPrice());
			order.displayOrder();
			while (jin.hasNextInt()) {
				try {
					int idx = jin.nextInt();
					order.removeItem(idx);
				} catch (Exception e) {
					System.out.println(e.getClass().getSimpleName());
				}
			}
			System.out.println(order.getPrice());
			order.displayOrder();
		}
		if (k == 3) { //test locking & exceptions
			Order order = new Order();
			try {
				order.lock();
			} catch (Exception e) {
				System.out.println(e.getClass().getSimpleName());
			}
			try {
				order.addItem(new ExtraItem("Coke"), 1);
			} catch (Exception e) {
				System.out.println(e.getClass().getSimpleName());
			}
			try {
				order.lock();
			} catch (Exception e) {
				System.out.println(e.getClass().getSimpleName());
			}
			try {
				order.removeItem(0);
			} catch (Exception e) {
				System.out.println(e.getClass().getSimpleName());
			}
		}
	}

}