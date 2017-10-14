package name.yuhongliang.algorithm.code;

public class MaxPathSum2 {
	
	private static class ResultType {
		int singlePath, maxPath;
		public ResultType(int singlePath, int maxPath) {
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		int result = maxPathSum(root);
		System.out.println(result);
		
		
	}

	
	private static int maxPathSum(TreeNode root) {
		ResultType result = helper(root);
		return result.maxPath;
	}

	private static ResultType helper(TreeNode root) {
		if (null == root) {
			return new ResultType(0, Integer.MIN_VALUE);
		}
		
		// Divide
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		
		// Conquer
		int singlePath = Math.max(0, Math.max(left.singlePath, right.singlePath) + root.val);
		int maxPath = Math.max(Math.max(left.maxPath, right.maxPath), left.singlePath + right.singlePath + root.val);
		
		return new ResultType(singlePath, maxPath);
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
