package problems;// EASY - https://leetcode.com/problems/diameter-of-binary-tree/

public class DiameterOfBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int max_so_far = 0;

    public int DiameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return max_so_far;
    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        max_so_far = Math.max(max_so_far, left + right);
        return 1 + Math.max(left, right);
    }
}
