package medium;

// 3160. Find the Number of Distinct Colors Among the Balls

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3160 {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> ballToCollor = new HashMap<>();
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0], color = queries[i][1];
            if (ballToCollor.containsKey(ball)) {
                int oldColor = ballToCollor.get(ball);
                map.get(oldColor).remove(ball);
                if (map.get(oldColor).size() == 0)
                    map.remove(oldColor);
            }
            ballToCollor.put(ball, color);
            map.computeIfAbsent(color, x -> new HashSet<>()).add(ball);
            ans[i] = map.size();
        }

        return ans;
    }
}
