package easy;

// 993. Cousins in Binary Tree

import util.TreeNode;

public class Solution993 {
    private int xDepth = -1;
    private TreeNode xParent = null;
    private int yDepth = -1;
    private TreeNode yParent = null;
    private int x;
    private int y;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, null, 0);
        return xDepth == yDepth && xParent != yParent;
    }

    private void dfs(TreeNode node, TreeNode pa, int depth) {
        if (xDepth != -1 && yDepth != -1)
            return;
        if (node.val == x) {
            xDepth = depth;
            xParent = pa;
        }
        if (node.val == y) {
            yDepth = depth;
            yParent = pa;
        }
        if (node.left != null)
            dfs(node.left, node, depth + 1);
        if (node.right != null)
            dfs(node.right, node, depth + 1);
    }
}
