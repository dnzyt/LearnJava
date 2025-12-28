package easy;

// 671. Second Minimum Node In a Binary Tree

import util.TreeNode;

import java.util.Set;
import java.util.TreeSet;

public class Solution671 {
    private long secondMin = Long.MAX_VALUE;
    private int rootMin;

    public int findSecondMinimumValue(TreeNode root) {
        rootMin = root.val;
        dfs(root);
        return secondMin == Long.MAX_VALUE ? -1 : (int) secondMin;
    }

    private void dfs(TreeNode node) {
        if (node.val > rootMin && node.val < secondMin)
            secondMin = node.val;
        if (node.left != null && node.left.val < secondMin)
            dfs(node.left);
        if (node.right != null && node.right.val < secondMin)
            dfs(node.right);
    }

}
