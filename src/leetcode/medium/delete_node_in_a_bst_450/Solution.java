package leetcode.medium.delete_node_in_a_bst_450;

public class Solution {

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}

		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			// Found node to delete
			if (root.left == null) {
				return root.right;
			}
			if (root.right == null) {
				return root.left;
			}

			// Two children: find inorder successor (min of right subtree)
			TreeNode succ = minNode(root.right);
			root.val = succ.val; // copy value
			// delete the successor node from the right subtree
			root.right = deleteNode(root.right, succ.val);
		}

		return root;
	}

	private TreeNode minNode(TreeNode node) {
		while (node.left != null) node = node.left;
		return node;
	}

}
