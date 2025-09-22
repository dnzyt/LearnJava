package easy;

// 1128. Number of Equivalent Domino Pairs

import java.util.HashMap;
import java.util.Map;

public class Solution1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        for (int[] d : dominoes) {
            if (d[0] > d[1]) {
                int t = d[0];
                d[0] = d[1];
                d[1] = t;
            }
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] d : dominoes) {
            int key = d[0] << 16 | d[1];
            int cnt = map.getOrDefault(key, 0);
            ans += cnt;
            map.put(key, cnt + 1);
        }
        return ans;
    }
}
