// MEDIUM - https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllNodesDistanceKInBinaryTree {

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

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        createGraph(root, null, graph);
        populateList(k, target.val, -1, graph, result); // bfs

        return result;
    }

    public void populateList(int k, int currentNode, int lastNode, HashMap<Integer, List<Integer>> graph, ArrayList<Integer> result) {
        if (k == 0) {
            result.add(currentNode);
            return;
        }
        var list = graph.getOrDefault(currentNode, new ArrayList<>());
        for (int i=0; i<list.size(); i++) {
            if (list.get(i) != lastNode) {
                populateList(k-1, list.get(i), currentNode, graph, result);
            }
        }
        return;
    }

    public void createGraph(TreeNode root, TreeNode parent, HashMap<Integer, List<Integer>> graph) {
        if (root == null) {
            return;
        }
        // root is key, children + parent are vals
        var list = graph.getOrDefault(root.val, new ArrayList<Integer>());
        if (root.left != null) {
            list.add(root.left.val);
        }
        if (root.right != null) {
            list.add(root.right.val);
        }
        // add root and parent
        if (parent != null) {
            list.add(parent.val);
        }
        graph.put(root.val, list);

        createGraph(root.left, root, graph);
        createGraph(root.right, root, graph);
    }

}
