// MEDIUM - https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

import java.util.Stack;

public class ConstructBinaryTreeFromPreorder {

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

     public TreeNode ConstructBinaryTreeFromPreorder(int[] preorder) {
         if (preorder.length == 0 || preorder == null) return null;
         Stack<TreeNode> stack = new Stack<TreeNode>();
         TreeNode root = new TreeNode(preorder[0]);
         stack.push(root);

         for (int i=1; i<preorder.length; i++) {
             TreeNode current = new TreeNode(preorder[i]);
             if (current.val < stack.peek().val) {
                 stack.peek().left = current;
             } else {
                 TreeNode parent = stack.peek();
                 while (!stack.isEmpty() && current.val > stack.peek().val) {
                     parent = stack.pop();
                 }
                 parent.right = current;
             }

             stack.push(current);
         }
         return root;
    }

}
