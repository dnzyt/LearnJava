package hard;

// 2218. Maximum Value of K Coins From Piles

import java.util.List;

public class Solution2218 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] f = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            List<Integer> p = piles.get(i - 1);
            int m = p.size();
            for (int j = 1; j <= k; j++) {
                f[i][j] = f[i - 1][j];
                int v = 0;
                for (int x = 1; x <= Math.min(j, m); x++) {
                    v += p.get(x - 1);
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - x] + v);
                }
            }
        }
        return f[n][k];
    }
}
