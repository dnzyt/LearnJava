package medium;

// 567. Permutation in String

import java.util.HashMap;
import java.util.Map;

public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char ch : s1.toCharArray())
            cnt.merge(ch, 1, Integer::sum);
        int j = 0;
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            cnt.merge(c, -1, Integer::sum);
            if (cnt.get(c) == 0)
                cnt.remove(c);
            if (i - j + 1 > s1.length()) {
                c = s2.charAt(j);
                cnt.merge(c, 1, Integer::sum);
                if (cnt.get(c) == 0)
                    cnt.remove(c);
                j++;
            }
            if (i - j + 1 == s1.length() && cnt.size() == 0)
                return true;
        }
        return false;
    }
}
