package easy;

// 1742. Maximum Number of Balls in a Box

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1742 {
    private char[] high;
    private char[] low;
    private Map<Integer, Integer> cntHigh;
    private Map<Integer, Integer> cntLow;

    public int countBalls(int lowLimit, int highLimit) {
        low = Integer.toString(lowLimit - 1).toCharArray();
        high = Integer.toString(highLimit).toCharArray();
        cntHigh = new HashMap<>();
        cntLow = new HashMap<>();

        dfs(0, 0, true, low, cntLow);
        dfs(0, 0, true, high, cntHigh);

        int ans = 0;
        for (int key : cntHigh.keySet()) {
            int v = cntHigh.get(key) - cntLow.getOrDefault(key, 0);
            ans = Math.max(ans, v);
        }
        return ans;
    }

    private void dfs(int i, int sum, boolean isLimited, char[] num, Map<Integer, Integer> cnt) {
        if (i == num.length) {
            cnt.merge(sum, 1, Integer::sum);
            return;
        }
        int up = isLimited ? num[i] - '0' : 9;
        for (int d = 0; d <= up; d++)
            dfs(i + 1, sum + d, isLimited && d == up, num, cnt);
        return;
    }
}
