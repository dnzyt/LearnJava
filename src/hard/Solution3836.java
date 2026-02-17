package hard;

// 3836. Maximum Score Using Exactly K Pairs

public class Solution3836 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;

        return dfs(m - 1, n - 1, k, nums1, nums2);
    }

    private long dfs(int i, int j, int k, int[] nums1, int[] nums2) {
        if (k == 0)
            return 0L;
        if (i + 1 < k || j + 1 < k)
            return Long.MIN_VALUE;

        long a = dfs(i - 1, j, k, nums1, nums2);
        long b = dfs(i, j - 1, k, nums1, nums2);
        long c = dfs(i - 1, j - 1, k - 1, nums1, nums2) + (long) nums1[i] * nums2[j];
        return Math.max(Math.max(a, b), c);
    }
}
