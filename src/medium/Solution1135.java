package medium;

// 1135. Connecting Cities With Minimum Cost

import java.util.*;

public class Solution1135 {
    // Prim
    public int minimumCost(int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] conn : connections) {
            int x = conn[0], y = conn[1], cost = conn[2];
            graph.computeIfAbsent(x, ArrayList::new).add(new int[] {cost, y});
            graph.computeIfAbsent(y, ArrayList::new).add(new int[] {cost, x});
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] {0, 1});
        int res = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (visited.contains(curr[1])) continue;
            res += curr[0];
            visited.add(curr[1]);
            pq.addAll(graph.getOrDefault(curr[1], new ArrayList<>()));
        }
        if (visited.size() != n)
            return -1;
        return res;

    }

}
