package medium;

// 78. Subsets

import java.util.ArrayList;
import java.util.List;

public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        return dfs(nums, 0);
    }

    private List<List<Integer>> dfs(int[] nums, int start) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length) {
            res.add(new ArrayList<>());
            return res;
        }
        for (List<Integer> df : dfs(nums, start + 1)) {
            res.add(df);
            ArrayList<Integer> t = new ArrayList<>(df);
            t.add(nums[start]);
            res.add(t);
        }
        return res;
    }

}
