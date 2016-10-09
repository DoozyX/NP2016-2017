package labs.lab1.p1;

import java.util.Scanner;
import java.util.stream.IntStream;

/*
Да се напише метод кој ќе прима еден цел број и ќе ја печати неговата репрезентација како Римски број.
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