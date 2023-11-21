package hard;

import javafx.util.Pair;

import java.util.*;

public class Solution2940 {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        List<List<Pair<Integer, Integer>>> query = new ArrayList<>();
        for (int i = 0; i < heights.length; i++)
            query.add(new ArrayList<>());
        for (int i = 0; i < queries.length; i++) {
            int aIdx = queries[i][0];
            int bIdx = queries[i][1];
            if (aIdx == bIdx) {
                res[i] = aIdx;
                continue;
            }
            if (aIdx < bIdx && heights[aIdx] < heights[bIdx]) {
                res[i] = bIdx;
                continue;
            }
            if (bIdx < aIdx && heights[bIdx] < heights[aIdx]) {
                res[i] = aIdx;
                continue;
            }
            int idx = Math.max(aIdx, bIdx);
            int highest = Math.max(heights[aIdx], heights[bIdx]);
            query.get(idx).add(new Pair<>(highest, i));
        }

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        for (int i = 0; i < heights.length; i++) {
            while (!pq.isEmpty() && pq.peek().getKey() < heights[i]) {
                var p = pq.poll();
                res[p.getValue()] = i;
            }
            for (Pair p: query.get(i)) {
                pq.add(p);
            }

        }
        return res;
    }
}
