package labs.lab7.p3;

import java.util.Scanner;

/**
 * Генеричка матрица Problem 3
 * Да се напише класа која е генеричка матрица од елементи. Сите елементи се од ист тип. Матрицата има две димензии број на редици и број на колони (сите редици имаат ист број на елементи – бројот на колони). Класата Matrix треба да ги имплементира следните методи:
 * <p>
 * Matrix(int numRows,int numCols) - креира нова матрица со дадените димезии, сите елементи се иницијализираат на null
 * getNumRow():int
 * getNumColumns():int
 * getElementAt(int row, int col) - го враќа елементот на соодветната позиција
 * setElementAt(int row, int col, T value) - го поставува елементот на соодветната позиција на новата вредност
 * fill(T element) - ги поставува вредностите на сите полиња во матрицата на element
 * insertRow(int row) - вметнува нов ред во матрицата на дадената позиција, сите редови после таа позиција се поместуваат за едно место во десно (си ги зголемуваат индексите за 1). Валидни вредности за row се [0, getNumRows()], во спротивно фрлете исклучок ArrayIndexOutOfBoundsException.
 * deleteRow(int row) - го брише соодветниот ред од матрицата, доколку има други редови после него тие се поместуваат во лево (нивните индекси се намалуваат за 1). Валидни вредности за row се [0, getNumRows()), во спротивно фрлете исклучок ArrayIndexOutOfBoundsException.
 * insertColumn(int col) - вметнува новa колона во матрицата на дадената позиција, сите колони после таа позиција се поместуваат за едно место во десно (си ги зголемуваат индексите за 1). Валидни вредности за col се [0, getNumColumns()], во спротивно фрлете исклучок ArrayIndexOutOfBoundsException.
 * deleteColumn (int col) - ја брише соодветната колона од матрицата, доколку има други колони после неа тие се поместуваат во лево (нивните индекси се намалуваат за 1). Валидни вредности за col се [0, getNumColumns()), во спротивно фрлете исклучок ArrayIndexOutOfBoundsException.
 * resize(int rows, int num) - врши промена на димензиите на матрицата. Доколку некоја димезнија е поголема од тековната новите полиња се иницијализираат на null. Ако некоја димензија е помала од тековната се врши отсекување на полињата кои се вишок.
 * <p>
 * За претставување на матрицата може да искористите:
 * <p>
 * ArrayList<ArrayList<T>> matrix;
 *
 Sample input
 0 5 3

 Sample output
 5 x 3
 0    1    2
 ---------------
 0|null null null
 1|null null null
 2|null null null
 3|null null null
 4|null null null
 */
public class MatrixTest {
	public static void main(String[] args) {
		Scanner jin = new Scanner(System.in);
		int t = jin.nextInt();
		if (t == 0) {
			int r = jin.nextInt();
			int c = jin.nextInt();
			Matrix<Integer> matrix = new Matrix<>(r, c);
			print(matrix);
		}
		if (t == 1) {
			int r = jin.nextInt();
			int c = jin.nextInt();
			Matrix<Integer> matrix = new Matrix<>(r, c);
			for (int i = 0; i < r; ++i) {
				for (int k = 0; k < c; ++k) {
					matrix.setElementAt(i, k, jin.nextInt());
				}
			}
			print(matrix);
		}
		if (t == 2) {
			int r = jin.nextInt();
			int c = jin.nextInt();
			Matrix<String> matrix = new Matrix<>(r, c);
			for (int i = 0; i < r; ++i) {
				for (int k = 0; k < c; ++k) {
					matrix.setElementAt(i, k, jin.next());
				}
			}
			print(matrix);
		}
		if (t == 3) {
			int r = jin.nextInt();
			int c = jin.nextInt();
			Matrix<String> matrix = new Matrix<>(r, c);
			for (int i = 0; i < r; ++i) {
				for (int k = 0; k < c; ++k) {
					matrix.setElementAt(i, k, jin.next());
				}
			}
			print(matrix);
			matrix.deleteRow(jin.nextInt());
			matrix.deleteRow(jin.nextInt());
			print(matrix);
			int ir = jin.nextInt();
			matrix.insertRow(ir);
			for (int k = 0; k < c; ++k) {
				matrix.setElementAt(ir, k, jin.next());
			}
			ir = jin.nextInt();
			matrix.insertRow(ir);
			for (int k = 0; k < c; ++k) {
				matrix.setElementAt(ir, k, jin.next());
			}
			print(matrix);
			matrix.deleteColumn(jin.nextInt());
			matrix.deleteColumn(jin.nextInt());
			print(matrix);
			int ic = jin.nextInt();
			matrix.insertColumn(ir);
			for (int i = 0; i < r; ++i) {
				matrix.setElementAt(i, ic, jin.next());
			}
			ic = jin.nextInt();
			matrix.insertColumn(ic);
			for (int i = 0; i < r; ++i) {
				matrix.setElementAt(i, ic, jin.next());
			}
			print(matrix);
		}
		if (t == 4) {
			int r = jin.nextInt();
			int c = jin.nextInt();
			Matrix<Integer> matrix = new Matrix<Integer>(r, c);
			for (int i = 0; i < r; ++i) {
				for (int k = 0; k < c; ++k) {
					matrix.setElementAt(i, k, jin.nextInt());
				}
			}
			print(matrix);
			int nr = jin.nextInt();
			int nc = jin.nextInt();
			matrix.resize(nr, nc);
			print(matrix);
			matrix.fill(jin.nextInt());
			print(matrix);
		}
	}

	public static void print(Matrix<?> m) {
		int r = m.getNumRows();
		int c = m.getNumColumns();
		System.out.println("  " + r + " x " + c);
		System.out.print("    ");
		for (int k = 0; k < c; ++k) {
			System.out.print(k + "    ");
		}
		System.out.println();
		System.out.print("  ");
		for (int k = 0; k < c; ++k) {
			System.out.print("-----");
		}
		System.out.println();
		for (int i = 0; i < r; ++i) {
			System.out.print(i + "|");
			for (int k = 0; k < c; ++k) {
				if (k > 0) System.out.print(" ");
				System.out.print(m.getElementAt(i, k));
			}
			System.out.println();
		}
		System.out.println();
	}

}