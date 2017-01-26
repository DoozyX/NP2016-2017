package exams.second.exercises.p1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class CarCollection {
	List<Car> cars;

	public CarCollection() {
		cars = new ArrayList<>();
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public void sortByPrice(boolean ascending) {
		if (ascending) {
			cars = cars.stream().sorted(Comparator.comparing(Car::getPrice).thenComparing(Car::getPower)).collect(Collectors.toList());
		} else {
			cars = cars.stream().sorted(Comparator.comparing(Car::getPrice).thenComparing(Car::getPower).reversed()).collect(Collectors.toList());
		}
	}

	public List<Car> filterByManufacturer(String manufacturer) {
		return cars.stream().filter(car -> car.getManufacturer().toLowerCase().equals(manufacturer.toLowerCase())).sorted(Comparator.comparing(Car::getModel)).collect(Collectors.toList());
	}

	public List<Car> getList() {
		return cars;
	}

}
