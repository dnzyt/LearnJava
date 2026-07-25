package hard;

// 3312. Sorted GCD Pair Queries

public class Solution3312 {
    public int[] gcdValues(int[] nums, long[] queries) {
        int mx = 0, n = nums.length;
        for (int num : nums)
            mx = Math.max(mx, num);
        int[] cntNum = new int[mx + 1];
        for (int num : nums)
            cntNum[num]++;
        long[] cntGcd = new long[mx + 1];
        for (int i = mx; i > 0; i--) {
            long c = 0;
            for (int j = i; j <= mx; j += i) {
                cntGcd[i] -= cntGcd[j];
                c += cntNum[j];
            }
            cntGcd[i] += c * (c - 1) / 2;
        }
        for (int i = 2; i <= mx; i++)
            cntGcd[i] += cntGcd[i - 1];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
            ans[i] = upperBound(cntGcd, queries[i]);
        return ans;
    }

    private int upperBound(long[] nums, long target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] <= target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }
}
