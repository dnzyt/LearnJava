package medium;

// 3243. Shortest Distance After Road Addition Queries I

import java.util.*;

public class Solution3243 {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++)
            g[i].add(i + 1);

        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            g[q[0]].add(q[1]);
            ans.add(bfs(g));
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private int bfs(List<Integer>[] g) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[g.length];
        q.offer(0);
        visited[0] = true;
        int count = 0;
        while (!q.isEmpty()) {
            int l = q.size();
            count++;
            while (l-- > 0) {
                int curr = q.poll();
                for (int nxt : g[curr]) {
                    if (nxt == g.length - 1)
                        return count;
                    if (!visited[nxt]) {
                        q.offer(nxt);
                        visited[nxt] = true;
                    }
                }
            }
        }
        return count;
    }
}
