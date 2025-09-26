package hard;

// 3027. Find the Number of Ways to Place People II

import java.util.Arrays;

public class Solution3027 {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int yi = points[i][1];
            int mx = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                int yj = points[j][1];
                if (mx < yj && yj <= yi) {
                    ans++;
                    mx = yj;
                }
                if (mx == yi) break;
            }
        }
        return ans;
    }
}
