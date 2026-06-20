package easy;

// 2341. Maximum Number of Pairs in Array

import java.util.HashMap;
import java.util.Map;

public class Solution2341 {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums)
            cnt.merge(num, 1, Integer::sum);
        int pairs = 0;
        for (int v : cnt.values())
            pairs += v / 2;
        return new int[]{pairs, nums.length - pairs * 2};
    }
}
