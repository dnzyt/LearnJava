package hard;

// 924. Minimize Malware Spread

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution924 {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        Arrays.sort(initial);
        int n = graph.length;
        Set<Integer> s = new HashSet<>();
        for (int x : initial)
            s.add(x);

        int ans = -1;
        int count = 0;
        for (int i : initial) {
            int t = dfs(graph, i, new boolean[n], s);
            if (t == -1)
                continue;
            if (count < t) {
                count = t;
                ans = i;
            }
        }
        if (ans == -1)
            return initial[0];
        return ans;
    }

    private int dfs(int[][] g, int i, boolean[] visited, Set<Integer> s) {
        visited[i] = true;
        int ans = 1;
        for (int j = 0; j < g.length; j++) {
            if (i != j && g[i][j] == 1 && !visited[j]) {
                if (s.contains(j))
                    return -1;

                int t = dfs(g, j, visited, s);
                if (t == -1)
                    return -1;
                ans += t;

            }
        }
        return ans;
    }


}
