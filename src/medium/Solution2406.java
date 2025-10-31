package medium;

// 2406. Divide Intervals Into Minimum Number of Groups

import java.util.*;

public class Solution2406 {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] itvl : intervals) {
            if (pq.isEmpty())
                pq.offer(itvl[1]);
            else {
                if (itvl[0] > pq.peek()) {
                    pq.poll();
                    pq.offer(itvl[1]);
                } else {
                    pq.offer(itvl[1]);
                }
            }
        }
        return pq.size();
    }

    // 差分
    public int minGroups2(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] itvl : intervals) {
            map.merge(itvl[0], 1, Integer::sum);
            map.merge(itvl[1] + 1, -1, Integer::sum);
        }
        int ans = 0;
        int sum = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            sum += e.getValue();
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
