// EASY - https://leetcode.com/problems/sum-of-left-leaves/

public class SumOfLeftLeaves {

    public class TreeNode {
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

    public int sumOfLeftLeaves(TreeNode root) {
        return sumLeftLeaf(root, false);
    }

    public int sumLeftLeaf(TreeNode root, boolean left) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && left) {
            return root.val;
        }
        return sumLeftLeaf(root.left, true) + sumLeftLeaf(root.right, false);
    }

}
