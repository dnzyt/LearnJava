package easy;

// 572. Subtree of Another Tree

import util.TreeNode;

public class Solution572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private boolean subtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null)
            return root == subRoot;
        if (root.val == subRoot.val) {
            boolean l = subtree(root.left, subRoot.left);
            boolean r = subtree(root.right, subRoot.right);
            if (l & r)
                return true;
        }
        return false;
    }

    private boolean dfs(TreeNode node, TreeNode subRoot) {
        if (node == null)
            return false;
        if (subtree(node, subRoot))
            return true;
        if (dfs(node.left, subRoot))
            return true;
        if (dfs(node.right, subRoot))
            return true;
        return false;
    }
}
