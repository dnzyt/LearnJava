package medium;

// 2415. Reverse Odd Levels of Binary Tree

import util.TreeNode;

public class Solution2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 1);
        return root;
    }

    // 对称二叉树的思想
    // LC 101 检查二叉树是否对称
    private void dfs(TreeNode l, TreeNode r, int depth) {
        if (l == null) return;
        if (depth % 2 > 0) {
            int temp = l.val;
            l.val = r.val;
            r.val = temp;
        }
        dfs(l.left, r.right, depth + 1);
        dfs(l.right, r.left, depth + 1);
        return;
    }
}
