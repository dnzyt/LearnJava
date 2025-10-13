package medium;

// 2564. Substring XOR Queries

import java.util.HashMap;
import java.util.Map;

public class Solution2564 {
    // 先做一次预处理，把所有可能的子串都遍历一遍，求出对应的[left, right]

    private static final int[] NOT_FOUND = new int[]{-1, -1};

    public int[][] substringXorQueries(String s, int[][] queries) {
        int idx = s.indexOf("0");
        Map<Integer, int[]> map = new HashMap<>();
        if (idx >= 0) {
            map.put(0, new int[]{idx, idx});
        }

        char[] c = s.toCharArray();
        int n = c.length;
        for (int l = 0; l < n; l++) {
            if (c[l] == '0') continue;
            int x = 0;
            for (int r = l; r < Math.min(n, l + 30); r++) {
                x = (x << 1) | (c[r] & 1);
                map.putIfAbsent(x, new int[]{l, r});
            }
        }

        int[][] ans = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = map.getOrDefault(queries[i][0] ^ queries[i][1], NOT_FOUND);
        }
        return ans;
    }
}
