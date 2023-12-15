package medium;

import java.util.HashMap;
import java.util.Map;

public class Solution825 {

    public int numFriendRequests(int[] ages) {
        Map<Integer, Integer> count = new HashMap<>();
        for (Integer age : ages) {
            count.put(age, count.getOrDefault(age, 0) + 1);
        }

        int res = 0;
        for (Integer i : count.keySet())
            for (Integer j : count.keySet()) {
                if (request(i, j))
                    res += (count.get(i) * (count.get(j) - (i == j ? 1 : 0)));
            }

        return res;

    }

    private boolean request(int a, int b) {
        return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100));
    }


}
