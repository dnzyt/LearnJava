package medium;

// 2285. Maximum Total Importance of Roads

import java.util.*;

public class Solution2285 {
    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int[] r : roads) {
            int a = r[0], b = r[1];
            cnt.merge(a, 1, Integer::sum);
            cnt.merge(b, 1, Integer::sum);
        }
        long ans = 0;
        List<Integer> v = new ArrayList<>(cnt.values());
        Collections.sort(v);
        for (int i = v.size() - 1; i >= 0; i--) {
            ans += ((long) v.get(i) * n);
            n--;
        }
        return ans;
    }
}
