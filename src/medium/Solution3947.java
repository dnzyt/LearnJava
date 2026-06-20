package medium;

// 3947. Maximum Number of Items From Sale II

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3947 {
    public int maximumSaleItems(int[][] items, int budget) {
        Map<Integer, Integer> factorCnt = new HashMap<>();
        int minPrice = Integer.MAX_VALUE;
        for (int[] item : items) {
            int fac = item[0], price = item[1];
            minPrice = Math.min(minPrice, price);
            factorCnt.merge(fac, 1, Integer::sum);
        }
        Map<Integer, Integer> factorMulti = new HashMap<>();
        Arrays.sort(items, (a, b) -> a[1] - b[1]);
        int ans = 0;
        for (int[] item : items) {
            int factor = item[0], price = item[1];
            if (price > minPrice * 2 || price > budget)
                break;
            if (!factorMulti.containsKey(factor)) {
                factorMulti.put(factor, -1);
                for (int j = factor; j <= items.length; j += factor)
                    factorMulti.merge(factor, factorCnt.getOrDefault(j, 0), Integer::sum);
            }

            int c = Math.min(factorMulti.get(factor), budget / price);
            ans += c * 2;
            budget -= c * price;
        }
        ans += (budget / minPrice);
        return ans;
    }
}
