package Array;

import java.util.Scanner;

public class Matrix {
	private int rows, columns = 0;
	private int [][] matrix;
	
	public Matrix(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.matrix = new int[rows][columns];
	}
	
	public Matrix(int rows, int columns, int... integers) {
		this.rows = rows;
		this.columns = columns;
		this.matrix = new int[rows][columns];
		int i, j, k = 0;
		if(this.rows * this.columns == integers.length) {
			while(k < integers.length) {
				for(i = 0; i < this.rows; i++) {
					for(j = 0; j < this.columns; j++) {
						this.matrix[i][j] = integers[k];
						k++;
					}
				}
			}
		}
	}

	public int getRows() {
		return rows;
	}

	@SuppressWarnings("unused")
	private void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	@SuppressWarnings("unused")
	private void setColumns(int columns) {
		this.columns = columns;
	}
	
	public int getElem(int m, int n) {
		return this.matrix[m][n];
	}
	
	public void setElem(int m, int n, int data) {
		this.matrix[m][n] = data;
	}
	
	public void addToPosition(int m, int n, int data) {
		this.matrix[m][n] += data;
	}
	
	public void addRow(int[] row, int idx) {
		if(row.length == columns) {
			for(int i = 0; i < matrix[idx].length; i++) {
				matrix[idx][i] = row[i];
			}
		}
	}
	
	public void addColumn(int[] column, int idx) {
		if(column.length == rows) {
			for(int j = 0; j < matrix[j][idx]; j++) {
				matrix[j][idx] = column[j];
			}
		}
	}
	
	public void scanInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please press 'Enter' to move to the next row");
		System.out.println("Please type 'end' to stop gving input");
		System.out.println("Enter the elements of the matrix from left to right.");
		String lineString = scanner.nextLine();
		String end = "end";
		int i = 0, j = -1;
		while (lineString != null & !lineString.equals(end)) {
			if(lineString.isEmpty() & lineString.isBlank()) {
				System.out.println("Next Row");
				i++;
				j = -1;
			} else {
				matrix[i][++j] = Integer.parseInt(lineString);
				System.out.println("Add to matrix: " + lineString + "  at position " + i + ", " + j);
			}
			
			if(scanner.hasNextLine()) {
				lineString = scanner.nextLine();
			} else {
				lineString = "end";
			}
		}
		scanner.close();
	}
	
	public void displayMatrix() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void initZeros() {
		for(int i = 0; i < this.getRows(); i++) {
			for(int j = 0; j < this.getColumns(); j++) {
				this.setElem(i, j, 0);
			}
		}
	}
	
	public void addTo(Matrix B) {
		if(this.getRows() == B.getRows() & this.getColumns() == B.getColumns()) {
			for(int i = 0; i < this.getRows(); i++) {
				for(int j = 0; j < this.getColumns(); j++) {
					this.addToPosition(i, j, this.getElem(i, j) + B.getElem(i, j));
				}
			}
		}
	}
	
	public static void addMatrix(Matrix A, Matrix B) {
		if(A.getRows() == B.getRows() & A.getColumns() == B.getColumns()) {
			Matrix C = new Matrix(A.getRows(), B.getColumns());
			for(int i = 0; i < A.getRows(); i++) {
				for(int j = 0; j < A.getColumns(); j++) {
					C.addToPosition(i, j, A.getElem(i, j) + B.getElem(i, j));
				}
			}
		}
	}
	
	public static boolean canMultiple(Matrix A, Matrix B) {
		if(A.getColumns() == B.getRows()) {
			return true;
		}
		return false;
	}
	
	public static Matrix matmul(Matrix A, Matrix B) {
		Matrix resultMatrix = new Matrix(A.getRows(), B.getColumns());
		if(canMultiple(A, B)) {
			for(int i = 0; i < A.getRows(); i++) {
				for(int j = 0; j < B.getColumns(); j++) {
					resultMatrix.setElem(i, j, 0);
					for(int k = 0; k < A.getColumns(); k++) {
						resultMatrix.addToPosition(i, j, A.getElem(i, k) * B.getElem(k, j));
					}
				}
			}
		}
		return resultMatrix;
	}
	
	public Matrix matMul(Matrix B) {
		Matrix resultMatrix = new Matrix(this.getRows(), B.getColumns());
		if(canMultiple(this, B)) {
			for(int i = 0; i < this.getRows(); i++) {
				for(int j = 0; j < B.getColumns(); j++) {
					resultMatrix.setElem(i, j, 0);
					for(int k = 0; k < this.getColumns(); k++) {
						resultMatrix.addToPosition(i, j, this.getElem(i, k) * B.getElem(k, j));
					}
				}
			}
		}
		return resultMatrix;
	}
	
	public void strassenMatMul() {
		
	}
	
}
