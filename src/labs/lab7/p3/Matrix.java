package labs.lab7.p3;

import java.util.ArrayList;

class Matrix<T> {
	private ArrayList<ArrayList<T>> matrix;

	public Matrix(int numRows, int numCols) {
		matrix = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			ArrayList<T> row = new ArrayList<>();
			for (int j = 0; j < numCols; j++) {
				row.add(null);
			}
			matrix.add(row);
		}

	}

	int getNumRows() {
		return matrix.size();
	}

	int getNumColumns() {
		return matrix.get(0).size();
	}

	T getElementAt(int row, int col) {
		return matrix.get(row).get(col);
	}

	void setElementAt(int row, int col, T value) {
		matrix.get(row).set(col, value);
	}

	void fill(T element) {
		for (int i = 0; i < getNumRows(); i++) {
			for (int j = 0; j < getNumColumns(); j++) {
				matrix.get(i).set(j, element);
			}
		}
	}

	void insertRow(int row) throws ArrayIndexOutOfBoundsException {
		if (row < 0 || row > getNumRows()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		ArrayList<T> arr = new ArrayList<>();
		for (int j = 0; j < getNumColumns(); j++) {
			arr.add(null);
		}
		matrix.add(row, arr);
	}

	void deleteRow(int row) throws ArrayIndexOutOfBoundsException {
		if (row < 0 || row > getNumRows()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		matrix.remove(row);
	}

	void insertColumn(int col) {
		if (col < 0 || col > getNumColumns()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		for (int i = 0; i < getNumRows(); i++) {
			matrix.get(i).add(col, null);
		}
	}

	void deleteColumn(int col) {
		if (col < 0 || col > getNumColumns()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		for (int i = 0; i < getNumRows(); i++) {
			matrix.get(i).remove(col);
		}
	}

	void resize(int rows, int cols) {
		int n = getNumRows();
		int m = getNumColumns();
		if (rows < n) {
			for (int i = rows; i < n; i++) {
				matrix.remove(rows);
			}
		}
		if (rows > n) {
			int nn = rows - n;
			for (int i = 0; i < nn; i++) {
				ArrayList<T> arr = new ArrayList<>();
				for (int j = 0; j < m; j++) {
					arr.add(null);
				}
				matrix.add(arr);
			}
		}
		n = getNumRows();
		if (cols < m) {
			for (int i = 0; i < n; i++) {
				for (int j = cols; j < m; j++) {
					matrix.get(i).remove(cols);
				}
			}
		}
		if (cols > m) {
			for (int i = 0; i < n; i++) {
				int mm = cols - m;
				for (int j = 0; j < mm; j++) {
					matrix.get(i).add(null);
				}
			}
		}
	}
}