package easy;

// 163. Missing Ranges

import java.util.ArrayList;
import java.util.List;

public class Solution163 {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        if (nums.length == 0)
            return List.of(List.of(lower, upper));
        List<List<Integer>> t = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1])
                continue;
            List<Integer> p = List.of(nums[i] + 1, nums[i + 1] - 1);
            t.add(p);
        }
        List<List<Integer>> ans = new ArrayList<>();
        if (lower < nums[0])
            ans.add(List.of(lower, nums[0] - 1));
        ans.addAll(t);
        if (upper > nums[nums.length - 1])
            ans.add(List.of(nums[nums.length - 1] + 1, upper));

        return ans;
    }
}
