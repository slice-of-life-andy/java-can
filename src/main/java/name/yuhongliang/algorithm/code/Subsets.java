package name.yuhongliang.algorithm.code;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.google.common.base.Functions;
import com.google.common.collect.Lists;

public class Subsets {

	public static void main(String[] args) {
		Subsets subsets = new Subsets();
		int[] nums = {1,2,3};
		ArrayList<ArrayList<Integer>> result = subsets.uiqueSubsets(nums);
		for(ArrayList<Integer> list : result) {
			if (list.isEmpty()) {
				System.out.println("empty set");
			} else {
				String item = Lists.transform(list, Functions.toStringFunction()).stream().collect(Collectors.joining(","));
				System.out.println(item);
			}
		}
	}
	
	public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<>();
		//subsetsHelper(result,list,nums,0);
		bitSubsetHelper(result,list,nums);
		return result;
	}

	public ArrayList<ArrayList<Integer>> uiqueSubsets(int[] nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<>();
		uniqueSubsetsHelper(result,list,nums,0);
		return result;
	}
	
	private void subsetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] nums, int pos) {
		result.add(new ArrayList<Integer>(list));
		for(int i = pos; i < nums.length; i++) {
			list.add(nums[i]);
			subsetsHelper(result, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}
	
	private void bitSubsetHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] nums) {
		int resultSize = 1 << nums.length;
		for (int i = 0; i < resultSize; i++) {
			for (int j = 0; j < nums.length; j++) {
				if ((i & 1 << j) > 0) {
					list.add(j);
				}
			}
			result.add(new ArrayList<>(list));
			list.clear();
		}
	}
	
	//bug
	private void uniqueSubsetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] nums, int pos) {
		result.add(new ArrayList<Integer>(list));
		for(int i = pos; i < nums.length; i++) {
			if(i != pos && nums[i] == nums[i-1]) {
				System.out.println("filter");
				continue;
			}
			list.add(nums[i]);
			subsetsHelper(result, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}

}
