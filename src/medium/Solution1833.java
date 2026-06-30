package medium;

// 1833. Maximum Ice Cream Bars

import java.util.TreeMap;

public class Solution1833 {
    public int maxIceCream(int[] costs, int coins) {
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        for (int cost : costs)
            cnt.merge(cost, 1, Integer::sum);
        int ans = 0;
        for (int cost : cnt.keySet()) {
            if (coins > cost * cnt.get(cost)) {
                ans += cnt.get(cost);
                coins -= cost * cnt.get(cost);
            } else {
                int c = coins / cost;
                ans += c;
                coins -= cost * c;
            }
        }
        return ans;
    }
}
