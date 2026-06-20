package medium;

// 2305. Fair Distribution of Cookies


public class Solution2305 {
    // 状压DP
    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        int[] sum = new int[1 << n];
        for (int i = 0; i < n; i++) {
            int num = cookies[i];
            int bit = 1 << i;
            for (int j = 0; j < bit; j++)
                sum[bit | j] = sum[j] + num;
        }
        int[][] f = new int[k][1 << n];
        f[0] = sum;
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < 1 << n; j++) {
                f[i][j] = f[i - 1][j]; // 新人分配到0个cookie的情况
                // 枚举每个状态的子集
                for (int s = j; s > 0; s = j & (s - 1)) {
                    f[i][j] = Math.min(Math.max(f[i - 1][j ^ s], sum[s]), f[i][j]);
                }
            }
        }
        return f[k - 1][(1 << n) - 1];
    }

    // 暴力DFS
    private int ans;

    public int distributeCookies2(int[] cookies, int k) {
        int n = cookies.length;
        int[] peoples = new int[k];
        ans = Integer.MAX_VALUE;
        dfs(0, cookies, k, peoples);
        return ans;
    }

    private void dfs(int i, int[] cookies, int k, int[] peoples) {
        if (i == cookies.length) {
            int mn = -1;
            for (int p : peoples)
                mn = Math.max(mn, p);
            ans = Math.min(ans, mn);
            return;
        }
        for (int j = 0; j < k; j++) {
            peoples[j] += cookies[i];
            dfs(i + 1, cookies, k, peoples);
            peoples[j] -= cookies[i];
        }
    }
}
