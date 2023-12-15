package medium;

public class Solution814 {
    public TreeNode pruneTree(TreeNode root) {
        boolean res = containsOne(root);
        return res ? root : null;
    }

    private boolean containsOne(TreeNode root) {
        if (root == null)
            return false;
        boolean l = containsOne(root.left);
        boolean r = containsOne(root.right);
        if (!l)
            root.left = null;
        if (!r)
            root.right = null;
        return l || r || root.val == 1;
    }

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
}
