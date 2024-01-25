package Array;

import java.util.Random;

public class Sort {
	public static MyArrays tools = new MyArrays();
	public static Random rn = new Random();
	
	public void BubbleSort(int[] array, int len) {
		for(int i = 0; i < len - 1; i++) {
			for(int j = 0; j < len - i - 1; j++) {
				if(array[j] > array[j+1]) {
					tools.swapElements(array, j, j+1);
				}
			}
		}
	}
	 
	public void InsertionSort(int[] array, int len) {
		int j, key = 0;
		for(int i = 1; i < len; i++) {
			key = array[i];
			j = i - 1;
			while(j >= 0 && array[j] > key) {
				array[j+1] = array[j];
				j = j - 1;
			}
			array[j+1] = key;
		}
	}
	
	public void SelectionSort(int[] array, int len) {;
		int lowest = 0, temp = 0;
		for(int i = 0; i < len - 1; i++) {
			lowest = i;
			for(int j = i + 1; j < len; j++) {
				if(array[j] < array[lowest]) {
					lowest = j;
				}
			}
			temp = array[lowest];
			array[lowest] = array[i];
			array[i] = temp;
		}
	}
	
	private void merge(int[] array, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		
		int[] L = new int[n1];
		int [] R = new int[n2];
		
		for(int i = 0; i < n1; i++) {
			L[i] = array[l + i];
		}
		for(int j = 0; j < n2; j++) {
			R[j] = array[m + 1 + j];
		}
		
		int i = 0, j = 0, k = l;
		while(i < n1 && j < n2) {
			if(L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}
		while (j < n2){
			array[k] = R[j];
			j++;
			k++;
		}
	}
	
	public void MergeSort(int[] array) {
		int l = 0, r = array.length - 1;
		
		if(l < r) {
			int m = l + (r - l) / 2;
			
			MergeSort(array, l, m);
			MergeSort(array, m+1, r);
			
			merge(array, l, m, r);
		}
	}
	
	private void MergeSort(int[] array, int l, int r) {
		if(l < r) {
			int m = l + (r - l) / 2;
			
			MergeSort(array, l, m);
			MergeSort(array, m+1, r);
			
			merge(array, l, m, r);
		}
	}
	
	private int partition(int[] array, int low, int high, String pivot_type) {
		int pivot_index = 0, pivot = 0, i = 0;
		if(pivot_type == "last") {
			pivot_index = high;
		} else if(pivot_type == "first") {
			pivot_index = low;
		} else if (pivot_type == "mid") {
			pivot_index = (low + high) / 2;
		} else {
			System.out.println("Yet to be coded");
		}
		
		pivot = array[pivot_index];
		
		if (pivot_type == "first") {
			i = high;
			for(int j = high; j > low; j--) {
				if(array[j] > pivot) {
					tools.swapElements(array, j, i);
					i--;
				}
			}
			tools.swapElements(array, i, pivot_index);
			return i;
		} else {	
			i = (low - 1);
			for(int j = low; j < high; j++) {
				if(array[j] < pivot) {
					i++;
					tools.swapElements(array, i, j);
				}
			}
			tools.swapElements(array, i+1, pivot_index);
			return (i+1);
		}		
	}
	
	private void QuickSort(int[] array, int low, int high, String pivot_type) {
		if(low < high) {
			int pi = partition(array, low, high, pivot_type);
			QuickSort(array, low, pi-1, pivot_type);
			QuickSort(array, pi+1, high, pivot_type);
		}
	}
	
	public void QuickSort(int[] array, String pivot_type) {
		int low = 0, high = array.length - 1;
		if(low < high) {
			int pi = partition(array, low, high, pivot_type);
			QuickSort(array, low, pi-1, pivot_type);
			QuickSort(array, pi+1, high, pivot_type);
		}
	}
}
