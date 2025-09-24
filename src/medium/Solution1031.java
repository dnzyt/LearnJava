package medium;

// 1031. Maximum Sum of Two Non-Overlapping Subarrays

public class Solution1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++)
            presum[i + 1] = presum[i] + nums[i];
        return Math.max(f(presum, firstLen, secondLen), f(presum, secondLen, firstLen));
    }

    private int f(int[] presum, int firstLen, int secondLen) {
        int firstMax = presum[firstLen];
        int ans = 0;
        for (int i = firstLen + secondLen - 1; i < presum.length - 1; i++) {
            firstMax = Math.max(firstMax, presum[i - secondLen + 1] - presum[i - secondLen - firstLen + 1]);
            int secondSum = presum[i + 1] - presum[i - secondLen + 1];
            ans = Math.max(ans, secondSum + firstMax);
        }
        return ans;
    }
}
