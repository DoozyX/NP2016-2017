package labs.lab1.p1;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Римски броеви Problem 1
 * Да се напише метод кој ќе прима еден цел број и ќе ја печати неговата репрезентација како Римски број.
 * <p>
 * Пример
 * <p>
 * Aко ако се повика со парамететар 1998, излезот треба да биде MCMXCVIII.
 * <p>
 * Sample input
 * 5
 * 6
 * 18
 * 554
 * 101
 * 1015
 * <p>
 * Sample output
 * VI
 * XVIII
 * DLIV
 * CI
 * MXV
 */

public class RomanConverterTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		IntStream.range(0, n)
				.forEach(x -> System.out.println(RomanConverter.toRoman(scanner.nextInt())));
		scanner.close();
	}
}