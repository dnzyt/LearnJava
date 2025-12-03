package medium;

// 3015. Count the Number of Houses at a Certain Distance I

import java.util.*;

public class Solution3015 {
    public int[] countOfPairs(int n, int x, int y) {
        int[] ans = new int[n + 1];
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            g[i].add(j);
            g[j].add(i);
        }
        g[x].add(y);
        g[y].add(x);
        for (int i = 0; i < n; i++)
            bfs(g, i, ans);

        return Arrays.copyOfRange(ans, 1, ans.length);
    }

    private void bfs(List<Integer>[] g, int source, int[] ans) {
        int dist = 0;
        int n = g.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(source);
        visited[source] = true;
        while (!q.isEmpty()) {
            int l = q.size();
            dist++;
            while (l-- > 0) {
                int curr = q.poll();
                for (int nxt : g[curr]) {
                    if (!visited[nxt]) {
                        q.offer(nxt);
                        visited[nxt] = true;
                        ans[dist]++;
                    }
                }
            }

        }
    }
}
