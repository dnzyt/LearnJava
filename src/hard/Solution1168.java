package hard;

// 1168. Optimize Water Distribution in a Village

import java.util.*;

public class Solution1168 {

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++)
            graph.computeIfAbsent(0, ArrayList::new).add(new int[] {wells[i], i + 1});
        for (int[] pipe : pipes) {
            int house1 = pipe[0];
            int house2 = pipe[1];
            int cost = pipe[2];
            graph.computeIfAbsent(house1, ArrayList::new).add(new int[] {cost, house2});
            graph.computeIfAbsent(house2, ArrayList::new).add(new int[] {cost, house1});
        }

        int res = 0;
        PriorityQueue<int[]> edges = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<Integer> visited = new HashSet<>();
        edges.add(new int[] {0, 0});

        while (!edges.isEmpty()) {
            int[] curr = edges.poll();
            int currCost = curr[0];
            int currHouse = curr[1];
            if (visited.contains(currHouse)) continue;
            visited.add(currHouse);
            res += currCost;
            if (visited.size() == n + 1) break;
            for (int[] edge : graph.getOrDefault(currHouse, new ArrayList<>())) {
                if (visited.contains(edge[1])) continue;
                edges.add(edge);
            }
        }
        return res;
    }

}
