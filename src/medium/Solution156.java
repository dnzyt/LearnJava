package medium;

// 156. Binary Tree Upside Down

import util.TreeNode;

public class Solution156 {
    private TreeNode ans;

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null)
            return root;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            ans = root;
            return;
        }
        dfs(root.left);
        TreeNode r = root.left;
        r.left = root.right;
        r.right = root;
        root.left = null;
        root.right = null;
    }
}
