package medium;

// 113. Path Sum II

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution113 {

    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ans;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) return;
        target -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (target == 0)
                ans.add(new ArrayList<>(path));
        } else {
            dfs(root.left, target);
            dfs(root.right, target);
        }
        target += root.val;
        path.remove(path.size() - 1);
    }
}
