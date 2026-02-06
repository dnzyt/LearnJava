package medium;

// 3825. Longest Strictly Increasing Subsequence With Non-Zero Bitwise AND

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution3825 {
    public int longestSubsequence(int[] nums) {
        int res = 0;
        int mx = 0;
        for (int num : nums)
            mx = Math.max(mx, num);
        int w = 32 - Integer.numberOfLeadingZeros(mx);
        for (int i = 0; i < w; i++) {
            List<Integer> g = new ArrayList<>();
            for (int num : nums) {
                if (((num >> i) & 1) != 0) {
                    int j = Collections.binarySearch(g, num);
                    if (j < 0)
                        j = ~j;
                    if (j < g.size())
                        g.set(j, num);
                    else
                        g.add(num);
                }
            }
            res = Math.max(res, g.size());
        }
        return res;
    }
}
