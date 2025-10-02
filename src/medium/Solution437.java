package medium;

// 437. Path Sum III

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution437 {
    private int ans;

    public int pathSum(TreeNode root, int targetSum) {
        ans = 0;
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L, 1);
        dfs(root, targetSum, 0L, cnt);
        return ans;
    }

    private void dfs(TreeNode root, int targetSum, Long upperSum, Map<Long, Integer> cnt) {
        if (root == null) return;
        upperSum += root.val;
        ans += cnt.getOrDefault(upperSum - targetSum, 0);
        cnt.merge(upperSum, 1, Integer::sum);
        dfs(root.left, targetSum, upperSum, cnt);
        dfs(root.right, targetSum, upperSum, cnt);
        cnt.merge(upperSum, -1, Integer::sum);
    }
}
