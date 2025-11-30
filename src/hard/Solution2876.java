package hard;

// 2876. Count Visited Nodes in a Directed Graph

import java.util.*;

public class Solution2876 {
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int[] inDeg = new int[n];
        List<Integer>[] rg = new List[n];
        Arrays.setAll(rg, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            inDeg[edges.get(i)]++;
            rg[edges.get(i)].add(i);
        }

        int[] ans = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            if (inDeg[i] == 0)
                q.offer(i);

        while (!q.isEmpty()) {
            int curr = q.poll();
            int nxt = edges.get(curr);
            inDeg[nxt]--;
            if (inDeg[nxt] == 0)
                q.offer(nxt);
        }

        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0 || inDeg[i] == -1)
                continue;
            List<Integer> ring = new ArrayList<>();
            int x = i;
            do {
                inDeg[x] = -1;
                ring.add(x);
                x = edges.get(x);
            } while (inDeg[x] != -1);
            for (int node : ring)
                rdfs(rg, node, ring.size(), ans, inDeg);
        }
        return ans;
    }

    public void rdfs(List<Integer>[] rg, int node, int depth, int[] ans, int[] inDeg) {
        ans[node] = depth;
        for (int nxt : rg[node])
            if (inDeg[nxt] == 0)
                rdfs(rg, nxt, depth + 1, ans, inDeg);
    }
}
