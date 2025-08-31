package medium;

// 39. Combination Sum

import java.util.ArrayList;
import java.util.List;

public class Solution39 {

    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0, candidates, target);
        return ans;
    }

    private void dfs(int i, int[] nums, int target) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (i == nums.length) return;

        path.add(nums[i]);
        dfs(i, nums, target - nums[i]); // 可以有重复数字
        path.remove(path.size() - 1);
        dfs(i + 1, nums, target);

    }


}
