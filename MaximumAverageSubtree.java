// MEDIUM - https://leetcode.com/problems/maximum-average-subtree/

public class MaximumAverageSubtree {

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

    double max = Integer.MIN_VALUE;

    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return max;
    }

    public double[] dfs(TreeNode root) {
        if (root == null) {
            // [0] = total_val
            // [1] = num_nodes
            return new double[]{0, 0};
        }
        double[] left = dfs(root.left);
        double[] right = dfs(root.right);
        double val = root.val + left[0] + right[0];
        double nodes = 1 + left[1] + right[1];
        max = Math.max(max, val / nodes);
        return new double[]{val, nodes};
    }

}
