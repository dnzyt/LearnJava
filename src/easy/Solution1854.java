package easy;

// 1854. Maximum Population Year

import java.util.Map;
import java.util.TreeMap;

public class Solution1854 {
    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> diff = new TreeMap<>();
        for (int[] log : logs) {
            diff.merge(log[0], 1, Integer::sum);
            diff.merge(log[1], -1, Integer::sum);
        }
        int s = 0;
        int ans = 0;
        int population = Integer.MIN_VALUE;
        for (Integer k : diff.keySet()) {
            int v = diff.get(k);
            s += v;
            if (population < s) {
                population = s;
                ans = k;
            }
        }
        return ans;
    }
}
