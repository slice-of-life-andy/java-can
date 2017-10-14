package name.yuhongliang.algorithm.code;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = {1, 8, 12, 5, 19, 7, 3, 77, 6, 10};
		quickSort2(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
//			System.out.println(array[i]);
		}
		Integer cc = new Integer(10);
	}

	private static void quickSort(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}
		
		int pivot = array[(start + end) / 2];
		int left = start;
		int right = end;
		while (left <= right) {
			while (left <= right && array[left] < pivot) {
				left++;
			}
			while (left <= right && array[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;
				
				left++;
				right--;
			}
			
		}
		quickSort(array, start, right);
		quickSort(array, left, end);
	}

	
	private static void quickSort2(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}
		
		int pivot = partition(array, start, end);
		
		quickSort2(array, start, pivot);
		quickSort2(array, pivot + 1, end);
	}

	private static int partition(int[] array, int start, int end) {
		int left = start, right = end + 1;
		int pivot = array[start];
		
		while (true) {
			while (array[++left] < pivot) {
				if (left == end) {
					break;
				}
			}
			
			while (array[--right] > pivot) {}
			
			if (left >= right) {
				break;
			}
			
			exch(array, left, right);
		}
		
		exch(array, start, right);
		
		return right;
	}

	private static void exch(int[] array, int left, int right) {
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}

}
