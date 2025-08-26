package easy;

import util.TreeNode;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) return false;
        return isSame(left.left, right.right) && isSame(left.right, right.left);
    }
}
