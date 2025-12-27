package easy;

// 563. Binary Tree Tilt

import util.TreeNode;

public class Solution563 {
    private int res;

    public int findTilt(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int l = dfs(node.left);
        int r = dfs(node.right);
        res += Math.abs(l - r);
        return l + r + node.val;
    }
}
