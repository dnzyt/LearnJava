package hard;

// 3864. Minimum Cost to Partition a Binary String

public class Solution3864 {
    private int[] presum;
    private int encCost;
    private int flatCost;

    public long minCost(String s, int encCost, int flatCost) {
        this.encCost = encCost;
        this.flatCost = flatCost;
        int n = s.length();
        presum = new int[n + 1];
        for (int i = 0; i < n; i++)
            presum[i + 1] = presum[i] + (s.charAt(i) == '0' ? 0 : 1);
        return dfs(0, n - 1);
    }

    private long dfs(int l, int r) {
        long x = presum[r + 1] - presum[l];
        long cost = x == 0 ? flatCost : (r - l + 1) * x * encCost;
        if ((r - l + 1) % 2 == 0) {
            int mid = (l + r) >>> 1;
            long left = dfs(l, mid);
            long right = dfs(mid + 1, r);
            cost = Math.min(cost, left + right);
        }
        return cost;
    }
}
