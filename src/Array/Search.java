package Array;

public class Search {
	
	public int LinearSearch(int[] array, int key) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == key)
				return i;
		}
		return -1;
	}
	
	public int BinarySearch(int[] array, int key) {
		int left = 0;
		int right = array.length - 1;
		return recursiveBinarySearch(array, left, right, key);
	}
	
	@SuppressWarnings("unused")
	private int iterativeBinarySearch(int[] array, int key) {
		int l = 0, r = array.length - 1;
		int m;
		while(l <= r) {
			m = l + (r - l) / 2;
			
			if(array[m] == key) {
				return m;
			}
			
			if(array[m] < key) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return -1;
	}
		
	private int recursiveBinarySearch(int[] array, int l, int r, int key) {
		if(r >= l) {
			int mid = l + (r - l) / 2;
		
			if(array[mid] == key)
				return mid;
			
			if(array[mid] < key) {
				return recursiveBinarySearch(array, mid + 1, r, key);
			} else {
				return recursiveBinarySearch(array, l, mid - 1, key);
			}
		}
		return -1;
	}
	
	
}
