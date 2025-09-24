package easy;

// 2506. Count Pairs Of Similar Strings

import java.util.HashMap;
import java.util.Map;

public class Solution2506 {
    public int similarPairs(String[] words) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= (1 << c - 'a');
            }
            int c = map.getOrDefault(mask, 0);
            ans += c;
            map.put(mask, c + 1);
        }
        return ans;
    }
}
