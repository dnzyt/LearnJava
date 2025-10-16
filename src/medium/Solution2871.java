package medium;

// 2871. Split Array Into Maximum Number of Subarrays

import java.util.stream.IntStream;

public class Solution2871 {
    public int maxSubarrays(int[] nums) {
        int x = -1;
        int res = 0;
        for (int num : nums) {
            x &= num;
            if (x == 0) {
                res++;
                x = -1;
            }
        }
        return Math.max(res, 1);
    }
}
