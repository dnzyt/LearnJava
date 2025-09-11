package hard;

// 124. Binary Tree Maximum Path Sum


import util.TreeNode;

public class Solution124 {
    private int ans;

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE / 2;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        ans = Math.max(ans, root.val + l + r);
        return Math.max(0, Math.max(l, r) + root.val);
    }
}
