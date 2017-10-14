package name.yuhongliang.algorithm.code;

public class MergeSort {

	
	public static void main(String[] args) {
		int[] array = {1, 8, 2, 5, 19, 7, 3, 77, 6, 10};
		int[] tmp = new int[array.length];
		mergeSort(array, 0, array.length - 1, tmp); 
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	private static void mergeSort(int[] array, int start, int end, int[] tmp) {
		if (start >= end) {
			return;
		}
		
		int mid = (start + end) / 2;
		mergeSort(array, start, mid, tmp);
		mergeSort(array, mid + 1, end, tmp);
		merge(array, start, mid, end, tmp);
	}

	private static void merge(int[] array, int start, int mid, int end, int[] tmp) {
		int left = start;
		int right = mid + 1;
		int index = start;
		
		while(left <= mid && right <= end) {
			if (array[left] < array[right]) {
				tmp[index++] = array[left++];
			} else {
				tmp[index++] = array[right++];
			}
		}
		while (left <= mid) {
			tmp[index++] = array[left++];
		}
		while (right <= end) {
			tmp[index++] = array[right++]; 
		}

		for (index = start; index <= end; index++) {
			array[index] = tmp[index];
		}
	}

}
