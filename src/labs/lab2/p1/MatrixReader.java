package labs.lab2.p1;

import java.io.InputStream;
import java.util.Scanner;

class MatrixReader {
	static DoubleMatrix read(InputStream input) throws InsufficientElementsException {
		Scanner scanner = new Scanner(input);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		double[] arr = new double[m * n];

		for (int i = 0; i < m * n; ++i) {
			arr[i] = scanner.nextDouble();
		}
		return new DoubleMatrix(arr, m, n);
	}
}

