package hard;

// 1547. Minimum Cost to Cut a Stick

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1547 {
    private int[][] memo;

    public int minCost(int n, int[] cuts) {
        List<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(n);
        for (int x : cuts) a.add(x);
        Collections.sort(a);
        int x = a.size();
        memo = new int[x][x];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dfs(0, a.size() - 1, a);
    }

    private int dfs(int i, int j, List<Integer> a) {
        if (i + 1 == j) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            ans = Math.min(ans, dfs(i, k, a) + dfs(k, j, a));
        }
        return memo[i][j] = ans + a.get(j) - a.get(i);
    }
}
