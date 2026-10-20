package hard;

// 2262. Total Appeal of A String

import java.util.HashMap;
import java.util.Map;

public class Solution2262 {
    public long appealSum(String s) {
        char[] chs = s.toCharArray();
        Map<Character, Integer> lastPos = new HashMap<>();
        long ans = 0L, sum = 0L;
        for (int i = 0; i < chs.length; i++) {
            int j = lastPos.getOrDefault(chs[i], -1);
            sum += i - j;
            ans += sum;
            lastPos.put(chs[i], i);
        }
        return ans;
    }
}
