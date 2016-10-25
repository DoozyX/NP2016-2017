package labs.lab1.p3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class ArrayReader {
    static IntegerArray readIntegerArray(InputStream input){
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        return new IntegerArray(arr);
    }
}
