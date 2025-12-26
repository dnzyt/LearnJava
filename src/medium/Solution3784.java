package medium;

// 3784. Minimum Deletion Cost to Make All Characters Equal

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3784 {
    public long minCost(String s, int[] cost) {
        int n = s.length();
        Map<Character, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.merge(ch, (long) cost[i], Long::sum);
        }

//        long sum = Arrays.stream(cost).mapToLong(x -> (long) x).sum();
        long sum = 0;
        for (int c : cost)
            sum += c;
        long ans = Long.MAX_VALUE;

        for (long x : map.values())
            ans = Math.min(ans, sum - x);
        return ans;
    }
}
