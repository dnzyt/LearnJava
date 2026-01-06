package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2857 {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        int ans = 0;
        Map<List<Integer>, Integer> cnt = new HashMap<>();
        for (List<Integer> coor : coordinates) {
            int x = coor.get(0);
            int y = coor.get(1);
            for (int i = 0; i <= k; i++)
                ans += cnt.getOrDefault(List.of(i ^ x, (k - i) ^ y), 0);
            cnt.merge(List.of(x, y), 1, Integer::sum);
        }
        return ans;
    }
}
