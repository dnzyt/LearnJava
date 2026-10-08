package medium;

// 78. Subsets

import java.util.ArrayList;
import java.util.List;

public class Solution78 {

    // 选或不选
    public List<List<Integer>> subsets(int[] nums) {
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
        dfs(i + 1, nums, path, ans);
        path.add(nums[i]);
        dfs(i + 1, nums, path, ans);
        path.remove(path.size() - 1);
    }

    // 枚举选哪个，从答案的视角看问题
    public List<List<Integer>> subsets2(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs2(0, nums, path, ans);
        return ans;
    }

    private void dfs2(int i, int[] nums, List<Integer> path, List<List<Integer>> ans) {
        int n = nums.length;
        ans.add(new ArrayList<>(path));
        if (i == n)
            return;
        for (int j = i; j < n; j++) {
            path.add(nums[j]);
            dfs2(j + 1, nums, path, ans);
            path.remove(path.size() - 1);
        }
    }

}
