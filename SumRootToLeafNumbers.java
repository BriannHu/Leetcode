// MEDIUM - https://leetcode.com/problems/sum-root-to-leaf-numbers/

public class SumRootToLeafNumbers {

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

    public int sumNumbers(TreeNode root) {
        return sumNodes(root, 0);
    }

    public int sumNodes(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }
        return sumNodes(root.left, sum * 10 + root.val) + sumNodes(root.right, sum * 10 + root.val);
    }
    }
