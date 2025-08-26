package easy;

// 530. Minimum Absolute Difference in BST

import util.TreeNode;

public class Solution530 {
    private int ans = Integer.MAX_VALUE;
    private int pre = Integer.MIN_VALUE / 2;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        ans = Math.min(ans, Math.abs(root.val - pre));
        pre = root.val;
        dfs(root.right);
        return;
    }
}
