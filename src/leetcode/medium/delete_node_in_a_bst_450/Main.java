package leetcode.medium.delete_node_in_a_bst_450;

public class Main {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode left1 = new TreeNode(1);
		TreeNode right1 = new TreeNode(7);
		root.left = left1;
		root.right = right1;

		TreeNode left2 = new TreeNode(2);
		TreeNode right2 = new TreeNode(6);
		right1.left = right2;
		left1.right = left2;

		TreeNode right3 = new TreeNode(10);
		right1.right = right3;

		Solution sol = new Solution();
		System.out.println(sol.deleteNode(root, 7));
	}

}
