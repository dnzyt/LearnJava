package medium;

// 1123. Lowest Common Ancestor of Deepest Leaves

import javafx.util.Pair;
import util.TreeNode;

public class Solution1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair<Integer, TreeNode> ans = dfs(root);
        return ans.getValue();
    }

    private Pair<Integer, TreeNode> dfs(TreeNode root) {
        if (root == null) return new Pair<>(0, null);
        Pair<Integer, TreeNode> left = dfs(root.left);
        Pair<Integer, TreeNode> right = dfs(root.right);
        if (left.getKey() < right.getKey()) {
            return new Pair<>(right.getKey() + 1, right.getValue());
        } else if (left.getKey() > right.getKey()) {
            return new Pair<>(left.getKey() + 1, left.getValue());
        } else {
            return new Pair<>(left.getKey() + 1, root);
        }
    }
}
