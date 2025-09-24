package medium;

// 3185. Count Pairs That Form a Complete Day II

public class Solution3185 {
    public long countCompleteDayPairs(int[] hours) {
        long[] d = new long[25];
        long ans = 0;
        for (int h : hours) {
            int r = h % 24;
            ans += d[(24 - r) % 24];
            d[r]++;
        }
        return ans;
    }
}
