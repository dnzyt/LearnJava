package medium;

// 687. Longest Univalue Path

import util.TreeNode;

public class Solution687 {
    private int res;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) return -1;
        int ans = 0;
        int leftLen = -1;
        int rightLen = -1;
        int l = dfs(node.left);
        int r = dfs(node.right);
        if (node.left != null && node.val == node.left.val) {
            leftLen = l;
            ans += (l + 1);
        }
        if (node.right != null && node.val == node.right.val) {
            rightLen = r;
            ans += (r + 1);
        }
        res = Math.max(res, ans);
        return Math.max(leftLen, rightLen) + 1;
    }
}
