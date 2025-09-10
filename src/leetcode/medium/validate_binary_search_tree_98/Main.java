package leetcode.medium.validate_binary_search_tree_98;

public class Main {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(4);
		root.left = left;
		root.right = right;

		Solution sol = new Solution();
		System.out.println(sol.isValidBST(root));
	}

}
