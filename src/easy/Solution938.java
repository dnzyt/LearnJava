package easy;

// 938. Range Sum of BST

import util.TreeNode;

public class Solution938 {

    private int ans;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return ans;
    }

    private void dfs(TreeNode root, int left, int right) {
        if (root == null) return;
        if (root.val >= left && root.val <= right) {
            ans += root.val;
            dfs(root.left, left, root.val);
            dfs(root.right, root.val, right);
        } else if (root.val < left) {
            dfs(root.right, left, right);
        } else {
            dfs(root.left, left, right);
        }
        return;
    }
}
