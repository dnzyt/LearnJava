package medium;

// 3900. Longest Balanced Substring After One Swap

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3900 {
    public int longestBalanced(String s) {
        int total0 = 0;
        int n = s.length();
        for (int i = 0; i < n; i++)
            if (s.charAt(i) == '0')
                total0++;
        int total1 = n - total0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, List.of(-1));
        int pre = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            pre += s.charAt(i) == '0' ? -1 : 1;
            if (map.containsKey(pre))
                ans = Math.max(ans, i - map.get(pre).get(0)); // 不交换

            // 1比0多两个
            if (map.containsKey(pre - 2)) {
                int idx = map.get(pre - 2).get(0);
                if ((i - idx - 2) / 2 < total0)
                    ans = Math.max(ans, i - idx);
                else if (map.get(pre - 2).size() == 2)
                    ans = Math.max(ans, i - map.get(pre - 2).get(1));
            }

            // 0比1多两个
            if (map.containsKey(pre + 2)) {
                int idx = map.get(pre + 2).get(0);
                if ((i - idx - 2) / 2 < total0)
                    ans = Math.max(ans, i - idx);
                else if (map.get(pre + 2).size() == 2)
                    ans = Math.max(ans, i - map.get(pre + 2).get(1));
            }

            if (!map.containsKey(pre))
                map.put(pre, new ArrayList<>());
            if (map.get(pre).size() < 2)
                map.get(pre).add(i);
        }
        return ans;
    }
}
