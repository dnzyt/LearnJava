package hard;

// 1639. Number of Ways to Form a Target String Given a Dictionary

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1639 {
    private static final int MOD = 1000000007;
    private Map<Character, Integer>[] map;
    private char[] t;
    private long[][] memo;

    public int numWays(String[] words, String target) {
        t = target.toCharArray();
        map = new HashMap[words[0].length()];
        Arrays.setAll(map, i -> new HashMap<>());
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                map[i].merge(word.charAt(i), 1, Integer::sum);
            }
        }
        memo = new long[words[0].length()][t.length];
        for (long[] row : memo)
            Arrays.fill(row, -1L);

        return (int) dfs(words[0].length() - 1, t.length - 1);
    }

    private long dfs(int i, int j) {
        if (i < j)
            return 0;
        if (j < 0)
            return 1;
        if (memo[i][j] != -1L)
            return memo[i][j];
        long ans = dfs(i - 1, j);
        if (map[i].containsKey(t[j])) {
            ans += map[i].get(t[j]) * dfs(i - 1, j - 1);
        }
        return memo[i][j] = ans % MOD;
    }

    public int numWays2(String[] words, String target) {
        int m = words[0].length();
        int n = target.length();
        int[][] freq = new int[m][26];
        for (String word : words) {
            for (int i = 0; i < m; i++)
                freq[i][word.charAt(i) - 'a']++;
        }

        long[] f = new long[n + 1];
        f[0] = 1L;
        for (int i = 0; i < m; i++) {
            for (int j = Math.min(i, n - 1); j >= 0; j--) {
                if (freq[i][target.charAt(j) - 'a'] > 0) {
                    f[j + 1] += f[j] * freq[i][target.charAt(j) - 'a'] % MOD;
                    f[j + 1] %= MOD;
                }
            }
        }
        return (int) f[n];
    }
}
