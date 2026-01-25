package medium;

// 2266. Count Number of Texts

import java.util.HashMap;
import java.util.Map;

public class Solution2266 {

    private static final int MOD = 1_000_000_007;
    private Map<Integer, Integer> memo = new HashMap<>();

    public int countTexts(String pressedKeys) {
        char[] ks = pressedKeys.toCharArray();
        return dfs(ks.length - 1, ks);
    }

    private int dfs(int i, char[] ks) {
        if (i < 0)
            return 1;
        if (memo.containsKey(i))
            return memo.get(i);
        int f = (ks[i] == '7' || ks[i] == '9') ? 4 : 3;
        int res = dfs(i - 1, ks);
        for (int j = 1; j < f; j++) {
            if (i - j >= 0 && ks[i - j] == ks[i])
                res += dfs(i - (j + 1), ks);
            else
                break;
            res %= MOD;
        }
        memo.put(i, res);
        return res;
    }

    public int countTexts2(String pressedKeys) {
        char[] ks = pressedKeys.toCharArray();
        int n = pressedKeys.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            char x = ks[i - 1];
            f[i] = f[i - 1];
            int limit = (x == '7' || x == '9') ? 4 : 3;
            for (int j = 1; j < limit; j++) {
                if (i - j > 0 && ks[i - 1] == ks[i - 1 - j])
                    f[i] += f[i - (j + 1)];
                else break;
                f[i] %= MOD;
            }
        }
        return f[n];
    }
}
