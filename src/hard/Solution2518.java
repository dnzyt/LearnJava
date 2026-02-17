package hard;

// 2518. Number of Great Partitions

public class Solution2518 {
    private static final int MOD = 1000000007;

    // 正难则反
    // 求出坏分区的个数，在用总的分区数-坏分区数
    public int countPartitions(int[] nums, int k) {
        long sum = 0L;
        for (int num : nums)
            sum += num;
        if (sum < k * 2) // 不可能有好分区
            return 0;
        int[] f = new int[k]; // 求坏分区的个数
        f[0] = 1;
        int total = 1;
        for (int num : nums) {
            total = (total * 2) % MOD;
            for (int j = k - 1; j >= num; j--)
                f[j] = (f[j] + f[j - num]) % MOD;
        }
        for (int x : f)
            total = (total - x * 2 % MOD + MOD) % MOD;
        return total;
    }
}
