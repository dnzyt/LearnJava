package medium;

// 2405. Optimal Partition of String

import java.util.HashSet;
import java.util.Set;

public class Solution2405 {
    public int partitionString(String s) {
        Set<Character> chs = new HashSet<>();
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (chs.contains(c)) {
                ans++;
                chs.clear();
            }
            chs.add(c);
        }
        ans++;
        return ans;
    }
}
