package medium;

// 2976. Minimum Cost to Convert String I

import java.util.Arrays;

public class Solution2976 {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();

        int[][] dist = new int[26][26];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        for (int i = 0; i < original.length; i++) {
            int x = original[i] - 'a';
            int y = changed[i] - 'a';
            dist[x][y] = Math.min(dist[x][y], cost[i]);
        }

        for (int k = 0; k < 26; k++)
            for (int i = 0; i < 26; i++)
                for (int j = 0; j < 26; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

        long ans = 0L;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(i))
                continue;
            if (dist[s[i] - 'a'][t[i] - 'a'] == Integer.MAX_VALUE / 2)
                return -1;
            ans += dist[s[i] - 'a'][t[i] - 'a'];
        }
        return ans;

    }
}
