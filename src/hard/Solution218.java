package hard;

// 218. The Skyline Problem

import java.util.*;

public class Solution218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        SortedSet<Integer> lines = new TreeSet<>();
        for (int[] b : buildings) {
            lines.add(b[0]);
            lines.add(b[1]);
            b[1]--;
        }
        Arrays.sort(buildings, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        int heigt = 0;
        for (int line : lines) {
            if (i < buildings.length && buildings[i][0] <= line) {
                pq.offer(new int[]{buildings[i][2], buildings[i][1]});
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < line)
                pq.poll();
            if (pq.isEmpty()) {
                heigt = 0;
                ans.add(List.of(0, line));
            } else {
                if (heigt != pq.peek()[0]) {
                    heigt = pq.peek()[0];
                    ans.add(List.of(heigt, line));
                }
            }
        }
        return ans;
    }
}
