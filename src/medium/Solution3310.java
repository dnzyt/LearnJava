package medium;

// 3310. Remove Methods From Project

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution3310 {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] g1 = new List[n];
        List<Integer>[] g2 = new List[n];
        Arrays.setAll(g1, i -> new ArrayList<>());
        Arrays.setAll(g2, i -> new ArrayList<>());
        for (int[] a : invocations) {
            g1[a[0]].add(a[1]);
            g2[a[1]].add(a[0]);
        }
        boolean[] suspicious = new boolean[n];
        dfs(k, g1, suspicious);

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (suspicious[i]) {
                if (expand(i, g2, visited, suspicious))
                    return IntStream.range(0, n).boxed().toList();
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i])
                ans.add(i);
        }
        return ans;
    }

    private void dfs(int i, List<Integer>[] g, boolean[] visited) {
        visited[i] = true;
        for (int nxt : g[i]) {
            if (!visited[nxt])
                dfs(nxt, g, visited);
        }
    }

    private boolean expand(int i, List<Integer>[] g, boolean[] visited, boolean[] suspicious) {
        visited[i] = true;
        for (int nxt : g[i]) {
            if (!suspicious[nxt])
                return true;
            if (!visited[nxt])
                expand(nxt, g, visited, suspicious);
        }
        return false;
    }
}
