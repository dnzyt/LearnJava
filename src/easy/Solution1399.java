package easy;

// 1399. Count Largest Group

import java.util.HashMap;
import java.util.Map;

public class Solution1399 {
    private char[] num;
    private Map<Integer, Integer> cnt;

    public int countLargestGroup(int n) {
        num = Integer.toString(n).toCharArray();
        cnt = new HashMap<>();
        dfs(0, 0, true);
        int ans = 0;
        int mx = 0;
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int k = e.getKey();
            int v = e.getValue();
            if (v > mx) {
                mx = v;
                ans = 1;
            } else if (v == mx)
                ans++;
        }
        return ans;
    }

    private void dfs(int i, int sum, boolean isLimited) {
        if (i == num.length) {
            if (sum != 0)
                cnt.merge(sum, 1, Integer::sum);
            return;
        }

        int high = isLimited ? num[i] - '0' : 9;
        for (int d = 0; d <= high; d++)
            dfs(i + 1, sum + d, isLimited && d == high);
        return;
    }
}
