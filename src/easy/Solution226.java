package easy;

// 226. Invert Binary Tree

import util.TreeNode;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);
        root.left = r;
        root.right = l;
        return root;
    }
}
