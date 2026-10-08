package medium;

// 40. Combination Sum II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {
    // 选或不选
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, candidates, target, path, ans);
        return ans;
    }

    private void dfs(int i, int[] candidates, int target, List<Integer> path, List<List<Integer>> ans) {
        int n = candidates.length;
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || i == n)
            return;

        path.add(candidates[i]);
        dfs(i + 1, candidates, target - candidates[i], path, ans);
        path.remove(path.size() - 1);
        int j = i + 1;
        // 既然不选，那么相同的都不能选
        while (j < n && candidates[j] == candidates[i])
            j++;
        dfs(j, candidates, target, path, ans);
    }

    // 枚举选哪个
    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs2(0, candidates, target, path, ans);
        return ans;
    }

    private void dfs2(int i, int[] nums, int target, List<Integer> path, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        int n = nums.length;
        if (target < 0 || i == n)
            return;
        for (int j = i; j < n; j++) {
            if (j > i && nums[j] == nums[j - 1])
                continue;
            path.add(nums[j]);
            dfs2(j + 1, nums, target - nums[j], path, ans);
            path.remove(path.size() - 1);

        }
    }


}
