package medium;

// 1234. Replace the Substring for Balanced String

import java.util.HashMap;
import java.util.Map;

public class Solution1234 {
    // sliding window
    public int balancedString(String s) {
        int required = s.length() / 4;
        Map<Character, Integer> counter = new HashMap<>();
        counter.put('Q', 0);
        counter.put('W', 0);
        counter.put('E', 0);
        counter.put('R', 0);
        for (Character c : s.toCharArray()) {
            int num = counter.get(c);
            counter.put(c, num + 1);
        }


        Map<Character, Integer> curr = new HashMap<>();
        curr.put('Q', 0);
        curr.put('W', 0);
        curr.put('E', 0);
        curr.put('R', 0);
        int r = 0;
        int res = s.length();
        for (int l = 0; l < s.length(); l++) {
            r = Math.max(l, r);
            while (r < s.length() && !isOk(counter, curr, required)) {
                int num = curr.get(s.charAt(r));
                curr.put(s.charAt(r), num + 1);
                r += 1;
            }
            if (isOk(counter, curr, required)) {
                res = Math.min(res, r - l);
            }
            int num = curr.get(s.charAt(l));
            curr.put(s.charAt(l), num - 1);
        }
        return res;
    }

    private boolean isOk(Map<Character, Integer> counter, Map<Character, Integer> curr, int required) {
        for (Character c : counter.keySet()) {
            int num1 = counter.get(c);
            int num2 = curr.get(c);
            if (num1 - num2 > required)
                return false;
        }
        return true;
    }
}
