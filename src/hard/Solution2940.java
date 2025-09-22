package hard;

import javafx.util.Pair;
import util.SimpleSegmentTree;

import java.util.*;

// 2940. Find Building Where Alice and Bob Can Meet

public class Solution2940 {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        List<int[]>[] qs = new ArrayList[heights.length];
        Arrays.setAll(qs, i -> new ArrayList<>());

        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] > queries[i][1]) {
                int t = queries[i][0];
                queries[i][0] = queries[i][1];
                queries[i][1] = t;
            }
            if (queries[i][0] == queries[i][1] || heights[queries[i][0]] < heights[queries[i][1]])
                ans[i] = queries[i][1];
            else {
                qs[queries[i][1]].add(new int[] {heights[queries[i][0]], i});
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < heights.length; i++) {
            int currHeight = heights[i];
            while (!pq.isEmpty() && pq.peek()[0] < currHeight) {
                ans[pq.poll()[1]] = i;
            }
            for (int[] q : qs[i])
                pq.offer(q);
        }

        return ans;
    }

    public int[] leftmostBuildingQueries2(int[] heights, int[][] queries) {
        SimpleSegmentTree st = new SimpleSegmentTree(heights);
        int n = heights.length;
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int aIdx = q[0];
            int bIdx = q[1];
            if (aIdx > bIdx) {
                int t = aIdx;
                aIdx = bIdx;
                bIdx = t;
            }
            if (aIdx == bIdx || heights[aIdx] < heights[bIdx]) ans[i] = bIdx;
            else ans[i] = st.findFirstInRange(bIdx + 1, heights.length - 1, heights[aIdx] + 1);
        }
        return ans;
    }
}
