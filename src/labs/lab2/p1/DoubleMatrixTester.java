package labs.lab2.p1;

import java.io.ByteArrayInputStream;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Матрица од реални броеви Problem 1 (1 / 3)
 * Да се напише класа која чува матрица од double вредности DoubleMatrix. Класата треба да е immutable, односно откако еднаш ќе се инстанцира да не може да се менува состојбата на објектот,
 * односно да не може да се менуваат податоците зачувани во него. За потребите на класата треба да се имплементираат следните методи:
 * <p>
 * DoubleMatrix(double a[], int m, int n) - конструктор кој прима низа од реални броеви каде што m и n се димензиите на матрицата. Од елементите на низата треба да се креира матрица.
 * Доколку нема доволно елементи во низата тогаш да се фрли исклучок InsufficientElementsException, а доколку има повеќе елементи да се земат последните m x n вредности и со нив се потполнува матрицата,
 * т.е. да се игнорираат вишокот на броеви од почетокот на низата
 * getDimensions():String - метод кој враќа стринг во формат [m x n]
 * rows():int - метод кој враќа број на редови
 * columns():int - метод кој враќа број на колони
 * maxElementAtRow(int row):double- метод кој го враќа максималниот елемент во дадениот ред, доколку вредноста е ред кој не постои да се фрли исклучок InvalidRowNumberException (row има вредност [1, m])
 * maxElementAtColumn(int column):double- метод кој го враќа максималниот елемент во дадената колона,
 * доколку вредноста е колона кој не постои да се фрли исклучок InvalidColumnNumberException (column има вредност [1, n])
 * sum() : double - метод кој ја враќа сумата на сите елементи од матрицата
 * toSortedArray():double[] – метод кој враќа еднодимензионална низа каде вредностите се сортирани во опаѓачки редослед
 * toString() - методот, каде броевите се заокружени на 2 децимални места, меѓу себе се одделени со табулаторско место \t а редовите на матрицата се одделени со нов ред
 * да се преоптоварат equals() и hashCode() методите
 * Забелешка: Исклучоците не треба да се фаќаат, треба само да се фрлаат
 * <p>
 * Да се дефинира класаInsufficientElementsException која што наследува од класата Exception и при фрлање на исклучок се добива порака"Insufficient number of elements"
 * <p>
 * Да се дефинира класа InvalidRowNumberExceptionкоја што наследува од класата Exception и при фрлање на исклучок се добива порака "Invalid row number"
 * <p>
 * Да се дефинира класа InvalidColumnNumberException која што наследува од класата Exception и при фрлање на исклучок се добива порака "Invalid column number"
 * <p>
 * Покрај класата DoubleMatrix треба да напишете дополнително уште една класа која ќе служи за вчитување на матрица од реални броеви од влезен тек на податоци.
 * Оваа класа треба да се вика MatrixReader и во неа треба да имате еден public static метод за вчитување на матрица од реални броеви од InputStream
 * <p>
 * read(InputStream input):DoubleMatrix - вчитува матрица од реални броеви од input зададена во следниот формат: Во првата линија има два цели броеви кои кажуваат колку редови и колони има матрицата,
 * а во наредните редови се дадени елементите на матрицата по редови, одделени со едно или повеќе празни места
 * <p>
 * Sample input
 * 5
 * INPUT_TEST
 * 3 5
 * 9.778627 -4.119295 -3.454750 2.467065 0.508486
 * 3.291531 7.843563 -6.448950 -3.498762 8.526385
 * 6.859716 1.669290 -8.034459 9.211680 5.779856
 * DIMENSION
 * SUM
 * DIMENSION
 * SORTED_ARRAY
 * <p>
 * Sample output
 * Dimensions: [3 x 5]
 * Sum: 30.38
 * Dimensions: [3 x 5]
 * Sorted array: [9.78, 9.21, 8.53, 7.84, 6.86, 5.78, 3.29, 2.47, 1.67, 0.51, -3.45, -3.50, -4.12, -6.45, -8.03]
 */

public class DoubleMatrixTester {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		int tests = scanner.nextInt();
		DoubleMatrix fm = null;

		double[] info = null;

		DecimalFormat format = new DecimalFormat("0.00");

		for (int t = 0; t < tests; t++) {

			String operation = scanner.next();

			switch (operation) {
				case "READ": {
					int N = scanner.nextInt();
					int R = scanner.nextInt();
					int C = scanner.nextInt();

					double[] f = new double[N];

					for (int i = 0; i < f.length; i++)
						f[i] = scanner.nextDouble();

					try {
						fm = new DoubleMatrix(f, R, C);
						info = Arrays.copyOf(f, f.length);

					} catch (InsufficientElementsException e) {
						System.out.println("Exception caught: " + e.getMessage());
					}

					break;
				}

				case "INPUT_TEST": {
					int R = scanner.nextInt();
					int C = scanner.nextInt();

					StringBuilder sb = new StringBuilder();

					sb.append(R + " " + C + "\n");

					scanner.nextLine();

					for (int i = 0; i < R; i++)
						sb.append(scanner.nextLine() + "\n");

					fm = MatrixReader.read(new ByteArrayInputStream(sb
							.toString().getBytes()));

					info = new double[R * C];
					Scanner tempScanner = new Scanner(new ByteArrayInputStream(sb
							.toString().getBytes()));
					tempScanner.nextDouble();
					tempScanner.nextDouble();
					for (int z = 0; z < R * C; z++) {
						info[z] = tempScanner.nextDouble();
					}

					tempScanner.close();

					break;
				}

				case "PRINT": {
					System.out.println(fm.toString());
					break;
				}

				case "DIMENSION": {
					System.out.println("Dimensions: " + fm.getDimensions());
					break;
				}

				case "COUNT_ROWS": {
					System.out.println("Rows: " + fm.rows());
					break;
				}

				case "COUNT_COLUMNS": {
					System.out.println("Columns: " + fm.columns());
					break;
				}

				case "MAX_IN_ROW": {
					int row = scanner.nextInt();
					try {
						System.out.println("Max in row: "
								+ format.format(fm.maxElementAtRow(row)));
					} catch (InvalidRowNumberException e) {
						System.out.println("Exception caught: " + e.getMessage());
					}
					break;
				}

				case "MAX_IN_COLUMN": {
					int col = scanner.nextInt();
					try {
						System.out.println("Max in column: "
								+ format.format(fm.maxElementAtColumn(col)));
					} catch (InvalidColumnNumberException e) {
						System.out.println("Exception caught: " + e.getMessage());
					}
					break;
				}

				case "SUM": {
					System.out.println("Sum: " + format.format(fm.sum()));
					break;
				}

				case "CHECK_EQUALS": {
					int val = scanner.nextInt();

					int maxOps = val % 7;

					for (int z = 0; z < maxOps; z++) {
						double work[] = Arrays.copyOf(info, info.length);

						int e1 = (31 * z + 7 * val + 3 * maxOps) % info.length;
						int e2 = (17 * z + 3 * val + 7 * maxOps) % info.length;

						if (e1 > e2) {
							double temp = work[e1];
							work[e1] = work[e2];
							work[e2] = temp;
						}

						DoubleMatrix f1 = fm;
						DoubleMatrix f2 = new DoubleMatrix(work, fm.rows(),
								fm.columns());
						System.out
								.println("Equals check 1: "
										+ f1.equals(f2)
										+ " "
										+ f2.equals(f1)
										+ " "
										+ (f1.hashCode() == f2.hashCode() && f1
										.equals(f2)));
					}

					if (maxOps % 2 == 0) {
						DoubleMatrix f1 = fm;
						DoubleMatrix f2 = new DoubleMatrix(new double[]{3.0, 5.0,
								7.5}, 1, 1);

						System.out
								.println("Equals check 2: "
										+ f1.equals(f2)
										+ " "
										+ f2.equals(f1)
										+ " "
										+ (f1.hashCode() == f2.hashCode() && f1
										.equals(f2)));
					}

					break;
				}

				case "SORTED_ARRAY": {
					double[] arr = fm.toSortedArray();

					String arrayString = "[";

					if (arr.length > 0)
						arrayString += format.format(arr[0]) + "";

					for (int i = 1; i < arr.length; i++)
						arrayString += ", " + format.format(arr[i]);

					arrayString += "]";

					System.out.println("Sorted array: " + arrayString);
					break;
				}

			}

		}

		scanner.close();
	}
}
