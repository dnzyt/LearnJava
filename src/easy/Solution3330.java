package easy;

// 3330. Find the Original Typed String I

import java.util.HashMap;
import java.util.Map;

public class Solution3330 {
    public int possibleStringCount(String word) {
        char pre = '#';
        int cnt = 1;
        int res = 1;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (pre == ch) {
                cnt++;
            } else {
                res += cnt - 1;
                cnt = 1;
                pre = ch;
            }
        }
        res += cnt - 1;
        return res;
    }
}

