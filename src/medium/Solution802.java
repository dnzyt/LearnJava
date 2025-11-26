package medium;

// 802. Find Eventual Safe States

import java.util.*;

public class Solution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        int[] inDeg = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int[] nextNodes = graph[i];
            if (nextNodes.length == 0)
                q.offer(i);
            for (int nxt : nextNodes) {
                inDeg[i]++;
                g[nxt].add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);
            for (int nxt : g[curr]) {
                inDeg[nxt]--;
                if (inDeg[nxt] == 0)
                    q.offer(nxt);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
