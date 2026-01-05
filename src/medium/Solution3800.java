package medium;

// 3800. Minimum Cost to Make Two Binary Strings Equal

public class Solution3800 {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        int n = s.length();
        int[][] cnt = new int[2][2];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - '0'][t.charAt(i) - '0']++;
        }

        int a = cnt[0][1], b = cnt[1][0];
        if (a > b) {
            int tt = a;
            a = b;
            b = tt;
        }

        long res1 = (long) (a + b) * flipCost;
        long res2 = (long) a * swapCost + (long) (b - a) * flipCost;
        int avg = (a + b) / 2;
        long res3 = (long) (avg - a) * crossCost + (long) avg * swapCost + (long) (a + b) % 2 * flipCost;

        return Math.min(res1, Math.min(res2, res3));
    }
}
