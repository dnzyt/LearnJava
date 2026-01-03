package easy;

// 965. Univalued Binary Tree

import util.TreeNode;

public class Solution965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;
        if (root.left != null && root.val != root.left.val)
            return false;
        if (root.right != null && root.val != root.right.val)
            return false;
        boolean l = isUnivalTree(root.left);
        boolean r = isUnivalTree(root.right);
        return l & r;

    }
}
