package problems;// EASY - https://leetcode.com/problems/cousins-in-binary-tree/

public class CousinsInBinaryTree {

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

    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDepth = -1;
    int yDepth = -1;

    public boolean isCousins(TreeNode root, int x, int y) {
        getDepthAndParent(root, x, y, 0, null);
        return (xDepth == yDepth) && (xParent != yParent);
    }

    // get both depth and parent for x and y
    public void getDepthAndParent(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if (root == null) {
            return;
        }

        if (root.val == x) {
            xDepth = depth;
            xParent = parent;
        }
        if (root.val == y) {
            yDepth = depth;
            yParent = parent;
        }
        getDepthAndParent(root.left, x, y, depth+1, root);
        getDepthAndParent(root.right, x, y, depth+1, root);
    }

}
