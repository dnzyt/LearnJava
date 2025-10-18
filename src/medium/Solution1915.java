package medium;

// 1915. Number of Wonderful Substrings

import java.util.HashMap;
import java.util.Map;

public class Solution1915 {

    // 前缀异或和+哈希
    public long wonderfulSubstrings(String word) {
        int n = word.length();
        int[] presum = new int[n + 1];
        char[] c = word.toCharArray();

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] ^ (1 << (c[i] - 'a'));
            ans += map.getOrDefault(presum[i + 1], 0);
            for (int j = 1; j < 1024; j <<= 1) {
                ans += map.getOrDefault(presum[i + 1] ^ j, 0);
            }
            map.merge(presum[i + 1], 1, Integer::sum);
        }
        return ans;
    }
}
