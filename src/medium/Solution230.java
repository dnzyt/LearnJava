package medium;

// 230. Kth Smallest Element in a BST

import util.TreeNode;

public class Solution230 {
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return inorder(root);
    }

    private int inorder(TreeNode root) {
        if (root == null)
            return -1;
        int x = inorder(root.left);
        if (this.k == 0)
            return x;
        this.k --;
        if (this.k == 0)
            return root.val;
        return inorder(root.right);
    }
}
