package medium;

// 257. Binary Tree Paths

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {
    private List<String> path = new ArrayList<>();
    private List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return List.of();
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        path.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            ans.add(String.join("->", path));
        } else {
            dfs(root.left);
            dfs(root.right);
        }
        path.remove(path.size() - 1);

    }
}
