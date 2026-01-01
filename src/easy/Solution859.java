package easy;

// 859. Buddy Strings

import java.util.HashMap;
import java.util.Map;

public class Solution859 {
    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        if (s.length() != goal.length())
            return false;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        int numOfDiff = 0;
        for (int i = 0; i < n; i++) {
            cnt1[s.charAt(i) - 'a']++;
            cnt2[goal.charAt(i) - 'a']++;
            if (s.charAt(i) != goal.charAt(i))
                numOfDiff++;
        }

        boolean ok = false;
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
            if (cnt1[i] > 1) ok = true;
        }
        return numOfDiff == 2 || numOfDiff == 0 && ok;
    }
}
