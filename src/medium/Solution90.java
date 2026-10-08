package medium;

// 90. Subsets II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {
    // 选或不选
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, nums, path, ans);
        return ans;
    }

    private void dfs(int i, int[] nums, List<Integer> path, List<List<Integer>> ans) {
        int n = nums.length;
        if (i == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[i]);
        dfs(i + 1, nums, path, ans);
        path.remove(path.size() - 1);
        int j = i + 1;
        while (j < n && nums[j] == nums[i])
            j++;
        dfs(j, nums, path, ans);
    }

    // 枚举选哪个
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs2(0, nums, path, ans);
        return ans;
    }

    private void dfs2(int i, int[] nums, List<Integer> path, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path));
        int n = nums.length;

        for (int j = i; j < n; j++) {
            if (j > i && nums[j] == nums[j - 1])
                continue;
            path.add(nums[j]);
            dfs2(j + 1, nums, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
