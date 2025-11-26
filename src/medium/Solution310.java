package medium;

// 310. Minimum Height Trees

import java.util.*;

public class Solution310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return List.of(0);
        if (n == 2)
            return List.of(0, 1);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegrees = new int[n];
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            indegrees[a] += 1;
            indegrees[b] += 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (indegrees[i] == 1)
                q.offerFirst(i);


        int res = 0;
        while (!q.isEmpty()) {
            int l = q.size();
            while (l > 0) {
                Integer curr = q.pollLast();
                res += 1;
                l--;
                for (Integer nei : graph.get(curr)) {
                    indegrees[nei] -= 1;
                    if (indegrees[nei] == 1)
                        q.offerFirst(nei);
                }
            }
            if (n - res <= 2)
                return q.stream().toList();
        }
        return new ArrayList<>();
    }

}
