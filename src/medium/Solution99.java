package medium;

// 99. Recover Binary Search Tree

import util.TreeNode;

public class Solution99 {
    private TreeNode first;
    private TreeNode second;
    private TreeNode last;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int v = first.val;
        first.val = second.val;
        second.val = v;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        if (last != null && last.val > root.val) {
            if (first == null)
                first = last;
            second = root;
        }
        last = root;
        dfs(root.right);
    }
}
