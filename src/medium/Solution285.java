package medium;

// 285. Inorder Successor in BST

import util.TreeNode;

public class Solution285 {
    // 中序遍历，找到第一个大于p的节点返回
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return root;
        TreeNode ans = inorderSuccessor(root.left, p);
        if (ans == null && root.val > p.val)
            return root;
        if (ans == null)
            ans = inorderSuccessor(root.right, p);
        return ans;
    }

}
