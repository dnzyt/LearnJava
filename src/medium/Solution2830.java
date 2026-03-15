package medium;

// 2830. Maximize the Profit as the Salesman

import java.util.*;

public class Solution2830 {
    // DP
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        List<int[]>[] groups = new List[n];
        Arrays.setAll(groups, i -> new ArrayList<>());
        for (List<Integer> offer : offers) {
            int start = offer.get(0);
            int end = offer.get(1);
            int val = offer.get(2);
            groups[end].add(new int[]{start, val});
        }
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            f[i + 1] = f[i];
            for (int[] e : groups[i]) {
                f[i + 1] = Math.max(f[i + 1], f[e[0]]);
            }
        }
        return f[n];
    }
}
