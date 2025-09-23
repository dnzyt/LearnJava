package medium;

// 1014. Best Sightseeing Pair

public class Solution1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int mx = values[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < values.length; i++) {
            ans = Math.max(ans, values[i] - i + mx);
            mx = Math.max(mx, values[i] + i);
        }
        return ans;
    }
}
