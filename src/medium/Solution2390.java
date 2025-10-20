package medium;

// 2390. Removing Stars From a String

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2390 {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        for (char c : chs) {
            if (c == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
