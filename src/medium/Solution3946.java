package medium;

// 3946. Maximum Number of Items From Sale I

import java.util.HashMap;
import java.util.Map;

public class Solution3946 {
    public int maximumSaleItems(int[][] items, int budget) {
        Map<Integer, Integer> factorCnt = new HashMap<>();
        int minPrice = Integer.MAX_VALUE;
        int[] f = new int[budget + 1];
        for (int[] item : items) {
            int fac = item[0], price = item[1];
            minPrice = Math.min(minPrice, price);
            factorCnt.merge(fac, 1, Integer::sum);
        }
        Map<Integer, Integer> factorMulti = new HashMap<>();
        for (int[] item : items) {
            int fac = item[0], price = item[1];
            if (!factorMulti.containsKey(fac)) {
                for (int j = fac; j <= 1500; j += fac)
                    factorMulti.merge(fac, factorCnt.getOrDefault(j, 0), Integer::sum);
            }
            for (int i = budget; i >= price; i--)
                f[i] = Math.max(f[i], f[i - price] + factorMulti.get(fac));
        }
        int ans = 0;
        for (int i = 0; i <= budget; i++)
            ans = Math.max(ans, f[i] + (budget - i) / minPrice);
        return ans;
    }
}
