package hard;

// 3333. Find the Original Typed String II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3333 {
    private static final int MOD = 1000000007;

    public int possibleStringCount(String word, int k) {
        List<Integer> cnts = new ArrayList<>();

        int cnt = 0;
        long ans = 1;
        for (int i = 0; i < word.length(); i++) {
            cnt++;
            if (i == word.length() - 1 || word.charAt(i) != word.charAt(i + 1)) {
                if (cnt > 1) {
                    if (k > 0)
                        cnts.add(cnt - 1);
                    ans = ans * cnt % MOD;
                }
                k--;
                cnt = 0;
            }
        }
        if (k <= 0)
            return (int) ans;

        int n = cnts.size();
        int[][] f = new int[n + 1][k];
        Arrays.fill(f[0], 1);
        for (int i = 1; i <= n; i++) {
            int[] presum = new int[k + 1];
            for (int j = 0; j < k; j++)
                presum[j + 1] = (presum[j] + f[i - 1][j]) % MOD;
            for (int j = 0; j < k; j++) {
                f[i][j] = (presum[j + 1] - presum[Math.max(j - cnts.get(i - 1), 0)] + MOD) % MOD;
            }
        }
        return (int) ((ans - f[n][k - 1] + MOD) % MOD);
    }

}
