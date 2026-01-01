package easy;

// 897. Increasing Order Search Tree

import util.TreeNode;

public class Solution897 {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode[] ans = dfs(root);
        return ans[0];
    }

    private TreeNode[] dfs(TreeNode root) {
        if (root.left == null && root.right == null)
            return new TreeNode[]{root, root};
        TreeNode[] ans = new TreeNode[]{root, root};

        if (root.left != null) {
            TreeNode[] l = dfs(root.left);
            root.left = null;
            ans[0] = l[0];
            l[1].right = root;
        }

        if (root.right != null) {
            TreeNode[] r = dfs(root.right);
            root.right = r[0];
            ans[1] = r[1];
        }

        return ans;
    }
}
