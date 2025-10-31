package medium;

// 3296. Minimum Number of Seconds to Make Mountain Height Zero

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3296 {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        long ans = 0;
        for (int w : workerTimes)
            pq.offer(new long[]{w, w, 2});
        while (mountainHeight > 0) {
            ans = pq.peek()[0];
            long[] curr = pq.poll();
            mountainHeight--;
            pq.offer(new long[]{curr[0] + curr[1] * curr[2], curr[1], curr[2] + 1});
        }
        return ans;
    }
}
