package name.yuhongliang.algorithm.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * http://blog.csdn.net/htq__/article/details/50908227
 * 
 * 要求：输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的
 * 节点形成一条路径
 * 
 * @author liequ
 *
 */
public class FindPath {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		TreeNode right = new TreeNode(2);
		right.left = new TreeNode(1);;
		root.right = right;
//		root.right = new TreeNode(2).left = new TreeNode(1);
		List<ArrayList<Integer>> result = new FindPath().findPath(root, 4);
		for (ArrayList<Integer> list : result) {
			System.out.println(list);
		}
	}

	public List<ArrayList<Integer>> findPath(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new <ArrayList<Integer>> ArrayList();
		Stack<Integer> stack = new Stack<>();
		findPath(root, result, stack, sum, 0);
		return result;
	}
	
	
	private void findPath(TreeNode root, ArrayList<ArrayList<Integer>> result, Stack<Integer> stack, int sum, int currentSum) {
		if (null == root) {
			return;
		}
		
		currentSum += root.val;
		stack.push(root.val);
		boolean isLeaf = root.left == null && root.right == null;
		if (isLeaf && sum == currentSum) {
			ArrayList<Integer> path = new ArrayList<>(stack);
			result.add(path);
		}
		
		if (currentSum > sum) {
			return;
		}
		
		findPath(root.left, result, stack, sum, currentSum);
		findPath(root.right, result, stack, sum, currentSum);
		
		stack.pop();
	}


	public static class TreeNode {
		public int val;
		public TreeNode left, right;
		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
}
