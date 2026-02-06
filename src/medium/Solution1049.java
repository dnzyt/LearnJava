package medium;

// 1049. Last Stone Weight II

public class Solution1049 {
    // 0-1背包
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int num : stones)
            sum += num;
        boolean[] f = new boolean[sum + 1];
        f[0] = true;
        for (int num : stones) {
            for (int j = sum; j >= num; j--)
                f[j] |= f[j - num];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++)
            if (f[i])
                ans = Math.min(ans, Math.abs(sum - i * 2));
        return ans;
    }
}
