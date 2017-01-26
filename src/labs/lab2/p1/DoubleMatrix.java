package labs.lab2.p1;

import java.util.Arrays;


class DoubleMatrix {
	private double[][] matix;

	DoubleMatrix(double a[], int m, int n) throws InsufficientElementsException {
		if (a.length < m * n) {
			throw new InsufficientElementsException();
		}
		matix = new double[m][n];
		for (int i = m - 1, k = a.length; i >= 0; --i) {
			for (int j = n - 1; j >= 0; --j) {
				matix[i][j] = a[--k];
			}
		}
	}

	public String getDimensions() {
		return String.format("[%d x %d]", matix.length, matix[0].length);
	}

	public int rows() {
		return matix.length;
	}

	public int columns() {
		return matix[0].length;
	}

	public double maxElementAtRow(int row) throws InvalidRowNumberException {
		if (row > rows() || row < 1) {
			throw new InvalidRowNumberException();
		}
		double max = matix[row - 1][0];
		for (int i = 1; i < columns(); ++i) {
			if (matix[row - 1][i] > max) {
				max = matix[row - 1][i];
			}
		}
		return max;
	}

	public double maxElementAtColumn(int column) throws InvalidColumnNumberException {
		if (column > columns() || column < 1) {
			throw new InvalidColumnNumberException();
		}
		double max = matix[0][column - 1];
		for (int i = 1; i < rows(); ++i) {
			if (matix[i][column - 1] > max) {
				max = matix[i][column - 1];
			}
		}
		return max;
	}

	public double sum() {
		return Arrays.stream(matix).flatMapToDouble(Arrays::stream).sum();
	}

	public double[] toSortedArray() {
		double[] arr = Arrays.stream(matix).flatMapToDouble(Arrays::stream).sorted().toArray();
		double[] reversed = new double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			reversed[i] = arr[arr.length - 1 - i];
		}
		return reversed;
	}

	@Override
	public String toString() {
		String separator = "\t";
		StringBuilder sb = new StringBuilder();
		int m = matix.length, n = matix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(String.format("%.2f", matix[i][j]));
				sb.append(separator);
			}
			sb.setLength(sb.length() - separator.length());
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DoubleMatrix)) return false;

		DoubleMatrix that = (DoubleMatrix) o;

		return Arrays.deepEquals(matix, that.matix);

	}

	@Override
	public int hashCode() {
		return Arrays.deepHashCode(matix);
	}
}
