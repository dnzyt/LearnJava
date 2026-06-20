package medium;

// 2333. Minimum Sum of Squared Difference

import java.util.*;

public class Solution2333 {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        List<Integer> a = new ArrayList<>();
        long ans = 0l;
        long sum = 0l;
        for (int i = 0; i < n; i++) {
            int c = Math.abs(nums1[i] - nums2[i]);
            a.add(c);
            ans += (long) c * c;
            sum += c;
        }
        int k = k1 + k2;
        if (sum <= k)
            return 0;
        Collections.sort(a, Collections.reverseOrder());
        a.add(0);
        for (int i = 0; i < n; i++) {
            long v = a.get(i);
            long nxtV = a.get(i + 1);
            int c = i + 1;
            long cnt = c * (v - nxtV);
            ans -= v * v;
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            v -= k / c;
            ans += (k % c) * (v - 1) * (v - 1);
            ans += (c - k % c) * v * v;
            return ans;
        }
        return ans;
    }
}
