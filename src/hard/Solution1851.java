package hard;

// 1851. Minimum Interval to Include Each Query

import java.util.*;

public class Solution1851 {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        SortedSet<int[]> t = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < queries.length; i++) {
            t.add(new int[]{queries[i], i});
        }
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int i = 0;
        for (int[] q : t) {
            int pos = q[0], idx = q[1];
            while (i < intervals.length && intervals[i][0] <= pos) {
                pq.offer(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < pos)
                pq.poll();
            if (!pq.isEmpty())
                ans[idx] = pq.peek()[0];
        }
        return ans;
    }
}
