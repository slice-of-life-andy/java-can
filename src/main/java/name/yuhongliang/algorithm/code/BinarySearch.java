package name.yuhongliang.algorithm.code;

public class BinarySearch {
	
	public static void main(String[] args) {
		
		int nums[] = {1,3,4,5,7,9,10};
		BinarySearch binarySearch = new BinarySearch();
		int position = binarySearch.binarySearch(nums, 11);
		
		System.out.println(String.format("target position is %d",position));
		
	}
	
	public int binarySearch(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				end = mid;
			} else if (nums[mid] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		if (nums[start] == target) {
			return start;
		} else if (nums[end] == target) {
			return end;
		}
		
		return -1;
	}

}
