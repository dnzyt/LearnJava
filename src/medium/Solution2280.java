package medium;

// 2280. Minimum Lines to Represent a Line Chart

import java.util.Arrays;
import java.util.Comparator;

public class Solution2280 {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
        int dx = 0, dy = 1;
        int ans = 0;
        for (int i = 1; i < stockPrices.length; i++) {
            int d1 = stockPrices[i][0] - stockPrices[i - 1][0];
            int d2 = stockPrices[i][1] - stockPrices[i - 1][1];
            if (dx * d2 != dy * d1) {
                ans++;
                dx = d1;
                dy = d2;
            }
        }
        return ans;
    }
}
