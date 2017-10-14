package name.yuhongliang.algorithm.code;


/**
 * http://blog.csdn.net/hzw05103020/article/details/51308033
 * 
 * 给一棵二叉树，找出从根节点出发的路径中，和最大的一条。
 * 这条路径可以在任何二叉树中的节点结束，但是必须包含至少一个点（也就是根了）。
 * 
 * @author liequ
 *
 */
public class MaxPathSum {
	public int maxSum = Integer.MIN_VALUE;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(new MaxPathSum().maxPathSum(root));
	}
	
	public  int maxPathSum(TreeNode root)  {
		process(root, 0);
		return maxSum;
	}
	
	
	private void process(TreeNode root, int sum) {
		if (null == root) {
			return;
		}
		
		sum += root.val;
		maxSum = Math.max(maxSum, sum);
		
		process(root.left, sum);
		process(root.right, sum);
		
		sum -= root.val; // backtracking
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
