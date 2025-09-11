package easy;

// 543. Diameter of Binary Tree

import util.TreeNode;

public class Solution543 {
    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return -1;
        int l = dfs(root.left) + 1;
        int r = dfs(root.right) + 1;
        ans = Math.max(ans, l + r);
        return Math.max(l, r);
    }
}
