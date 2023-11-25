package medium;

// 368. Largest Divisible Subset

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> dp = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++)
            dp.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            int count = 1;
            int idx = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && count <= dp.get(j).size()) {
                    count = dp.get(j).size();
                    idx = j;
                }
            }
            dp.get(i).addAll(dp.get(idx));
            dp.get(i).add(nums[i]);
        }

        return dp.stream().max((a, b) -> a.size() - b.size()).orElseThrow();

    }
}
