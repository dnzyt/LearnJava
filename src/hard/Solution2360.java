package hard;

// 2360. Longest Cycle in a Graph

public class Solution2360 {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int clock = 1;
        int[] time = new int[n];
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (time[i] > 0)
                continue;
            int startTime = clock;
            int x = i;
            while (x != -1 && time[x] == 0) {
                time[x] = clock;
                clock++;
                x = edges[x];
            }
            if (x != -1 && time[x] >= startTime)
                ans = Math.max(ans, clock - time[x]);
        }
        return ans;
    }
}
