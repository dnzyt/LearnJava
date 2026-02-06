package medium;

// 1774. Closest Dessert Cost

import java.util.HashSet;
import java.util.Set;

public class Solution1774 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int n = baseCosts.length, m = toppingCosts.length;
        int toppingTypes = (int) Math.pow(3.0, m); // 3进制表示
        Set<Integer> toppings = new HashSet<>();
        for (int i = 0; i < toppingTypes; i++) {
            String select = Integer.toString(i, 3);
            int cost = 0;
            for (int j = 0; j < select.length(); j++) {
                cost += toppingCosts[j + m - select.length()] * (select.charAt(j) - '0');
            }
            toppings.add(cost);
        }
        int ans = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int base : baseCosts) {
            for (int topping : toppings) {
                if (Math.abs(target - (base + topping)) < diff || Math.abs(target - (base + topping)) == diff && base + topping < ans) {
                    ans = base + topping;
                    diff = Math.abs(target - (base + topping));
                }
            }
        }
        return ans;
    }
}
