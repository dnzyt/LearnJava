package easy;

import util.TreeNode;

public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int l = getHeight(root.left);
        if (l == -1) return -1;
        int r = getHeight(root.right);
        if (r == -1 || Math.abs(l - r) > 1) return -1;
        return Math.max(l, r) + 1;
    }
}
