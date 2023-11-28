package medium;

// 3. Longest Substring Without Repeating Characters

import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray();
        Set<Character> visited = new HashSet<>();
        int j = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j <= i && visited.contains(ss[i])) {
                visited.remove(ss[j]);
                j ++;
            }
            visited.add(ss[i]);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

}
