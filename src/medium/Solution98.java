package medium;

// 98. Validate Binary Search Tree

public class Solution98 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long leftBound, long rightBound) {
        if (root == null)
            return true;
        if (root.val > leftBound && root.val < rightBound)
            return validate(root.left, leftBound, root.val) && validate(root.right, root.val, rightBound);
        return false;
    }

}
