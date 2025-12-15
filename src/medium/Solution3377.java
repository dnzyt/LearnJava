package medium;

// 3377. Digit Operations to Make Two Integers Equal

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3377 {
    private static final int MX = 10000;
    private static final boolean[] np = new boolean[MX]; // true - not prime

    static {
        // 埃氏筛
        np[1] = true;
        for (int i = 2; i < MX; i++) {
            if (!np[i]) {
                for (int j = i * i; j < MX; j += i)
                    np[j] = true;
            }
        }
    }

    // Dijkstra
    public int minOperations(int n, int m) {
        if (!np[n] || !np[m])
            return -1;
        int lenN = Integer.toString(n).length();
        int[] dist = new int[(int) Math.pow(10, lenN)];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[n] = n;

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[]{n, n});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int d = curr[0];
            int currNum = curr[1];
            if (currNum == m)
                return d;
            if (d > dist[currNum])
                continue;
            int pow10 = 1;
            for (int v = currNum; v > 0; v /= 10) {
                int digit = v % 10;
                if (digit > 0) {
                    int nxtNum = currNum - pow10;
                    if (np[nxtNum] && d + nxtNum < dist[nxtNum]) {
                        dist[nxtNum] = d + nxtNum;
                        q.offer(new int[]{dist[nxtNum], nxtNum});
                    }
                }
                if (digit < 9) {
                    int nxtNum = currNum + pow10;
                    if (np[nxtNum] && d + nxtNum < dist[nxtNum]) {
                        dist[nxtNum] = d + nxtNum;
                        q.offer(new int[]{dist[nxtNum], nxtNum});
                    }
                }
                pow10 *= 10;
            }
        }
        return -1;
    }
}
