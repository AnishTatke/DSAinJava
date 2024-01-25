package Array;

public class MyArrays {
	
	public static void printArray(int[] array) {
		System.out.print("|  ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  |  ");
		}
		System.out.println();
	}
	
	public void iterateIntegerSingleArray() {
		int[] intarr = new int[5];
		intarr[0] = 1;
		intarr[1] = 1;
		intarr[2] = 1;
		intarr[3] = 2;
		intarr[4] = 3;
		
		for(int i = 0; i < intarr.length; i++) {
			System.out.println("Element at index " + i + " is " + intarr[i]);
		}
	}
	
	
	public void iterateIntegerMatrixArray() {
		int[][] matrix = new int[3][3];
		matrix[0][0] = 1;
		matrix[0][1] = 1;
		matrix[0][2] = 1;
		matrix[1][0] = 4;
		matrix[1][1] = 4;
		matrix[1][2] = 4;
		matrix[2][0] = 9;
		matrix[2][1] = 9;
		matrix[2][2] = 9;
		
		for(int j = 0; j < matrix.length; j++) {
			for(int i = 0; i < matrix[j].length; i++) {
				System.out.print(matrix[j][i] + "\t");
			}
			System.out.println("\n");
		}
	}
	
	public void getIntArraySum(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		
		System.out.println("Sum is " + sum);
	}
	
	public void getDeepCopyOfArray(Object[] arr) {
		Object[] cloneArr = arr.clone();
		
		System.out.println("Are original and clone same?: " + (cloneArr == arr));
		for(Object num : cloneArr) {
			System.out.println("Element: " + num);
		}
	}
	
	public void swapElements(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
