package medium;

// 3752. Lexicographically Smallest Negated Permutation that Sums to Target

import java.util.*;

public class Solution3752 {
    // 这道题其实是一道数学题
    // 需要证明如下结论
    // 1~n的数列和为S，那么1~S中的任意数都可以从1~n中取出若干数相加得到

    public int[] lexSmallestNegatedPerm(int n, long target) {
        long sum = (long) (1 + n) * n / 2;
        if (sum < Math.abs(target) || (sum - target) % 2 == 1)
            return new int[]{};
        long negative = (sum - target) / 2;

        int[] ans = new int[n];
        int p1 = 0, p2 = n - 1;
        // 对于任意1~S中的数，其中一种取法就是从大到小试，如果够大就取
        for (int i = n; i >= 1; i--) {
            if (negative >= i) {
                ans[p1++] = -i;
                negative -= i;
            } else {
                ans[p2--] = i;
            }
        }
        return ans;

    }

}
