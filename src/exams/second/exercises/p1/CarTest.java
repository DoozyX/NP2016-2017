package exams.second.exercises.p1;

import java.util.List;
import java.util.Scanner;

/**
 * Автомобили (30 поени) Problem 1
 * Да се напише класа за автомобил Car во која се чува:
 * <p>
 * производител
 * модел
 * цена
 * моќност.
 * Да се имплементира конструктор со следните аргументи Car(String manufacturer, String model, int price, float power).
 * <p>
 * Потоа да се напише класа CarCollection во која се чува колекција од автомобили. Во оваа класа треба да се имплментираат следните методи:
 * <p>
 * public void addCar(Car car) - додавање автомобил во колекцијата
 * public void sortByPrice(boolean ascending) - подредување на колекцијата по цената на автомобилот (во растечки редослед ако аргументот ascending е true, во спротивно, во опаѓачки редослед).
 * Ако цената на автомобилите е иста, сортирањето да се направи според нивната моќноста.
 * public List<Car> filterByManufacturer(String manufacturer) - враќа листа со автомобили од одреден производител (споредбата е според името на производителот без да се води сметка за големи и мали букви во името).
 * Автомобилите во оваа листата треба да бидат подредени според моделот во растечки редослед.
 * public List<Car> getList() - ја враќа листата со автомобили од колекцијата.
 *
 * Sample input
 Fiat Punto 13500 65
 Ford Fiesta 14200 75
 VW Polo 13800 77
 Renault Clio 12100 96
 Mazda 2 14200 74
 Citroen C2 12900 64
 Ford Focus 16200 88
 VW Golf 17100 94
 Mazda 3 16500 91
 Renault Megan 16900 96
 Fiat Stilo 17100 92
 mAzda
 *
 *Sample output
 === Sorted By Price ASC ===
 Renault Clio (96KW) 12100
 Citroen C2 (64KW) 12900
 Fiat Punto (65KW) 13500
 VW Polo (77KW) 13800
 Mazda 2 (74KW) 14200
 Ford Fiesta (75KW) 14200
 Ford Focus (88KW) 16200
 Mazda 3 (91KW) 16500
 Renault Megan (96KW) 16900
 Fiat Stilo (92KW) 17100
 VW Golf (94KW) 17100
 === Sorted By Price DESC ===
 VW Golf (94KW) 17100
 Fiat Stilo (92KW) 17100
 Renault Megan (96KW) 16900
 Mazda 3 (91KW) 16500
 Ford Focus (88KW) 16200
 Ford Fiesta (75KW) 14200
 Mazda 2 (74KW) 14200
 VW Polo (77KW) 13800
 Fiat Punto (65KW) 13500
 Citroen C2 (64KW) 12900
 Renault Clio (96KW) 12100
 === Filtered By Manufacturer: mAzda ===
 Mazda 2 (74KW) 14200
 Mazda 3 (91KW) 16500
 */


public class CarTest {
	public static void main(String[] args) {
		CarCollection carCollection = new CarCollection();
		String manufacturer = fillCollection(carCollection);
		carCollection.sortByPrice(true);
		System.out.println("=== Sorted By Price ASC ===");
		print(carCollection.getList());
		carCollection.sortByPrice(false);
		System.out.println("=== Sorted By Price DESC ===");
		print(carCollection.getList());
		System.out.printf("=== Filtered By Manufacturer: %s ===\n", manufacturer);
		List<Car> result = carCollection.filterByManufacturer(manufacturer);
		print(result);
	}

	static void print(List<Car> cars) {
		for (Car c : cars) {
			System.out.println(c);
		}
	}

	static String fillCollection(CarCollection cc) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			String[] parts = line.split(" ");
			if (parts.length < 4) return parts[0];
			Car car = new Car(parts[0], parts[1], Integer.parseInt(parts[2]),
					Float.parseFloat(parts[3]));
			cc.addCar(car);
		}
		scanner.close();
		return "";
	}
}


// vashiot kod ovde