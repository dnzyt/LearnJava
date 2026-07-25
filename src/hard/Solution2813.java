package hard;

// 2813. Maximum Elegance of a K-Length Subsequence

import java.util.*;

public class Solution2813 {
    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        List<Integer> l = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        long totalProfit = 0, ans = 0;
        for (int i = 0; i < items.length; i++) {
            int profit = items[i][0], category = items[i][1];
            if (i < k) {
                totalProfit += profit;
                if (visited.contains(category)) {
                    l.add(profit);
                } else {
                    visited.add(category);
                }
            } else {
                if (l.isEmpty() || visited.contains(category))
                    continue;
                totalProfit -= l.removeLast();
                totalProfit += profit;
                visited.add(category);
            }
            ans = Math.max(ans, totalProfit + (long) visited.size() * visited.size());
        }
        return ans;
    }
}
