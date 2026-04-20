package medium;

// 1456. Maximum Number of Vowels in a Substring of Given Length

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1456 {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        int n = s.length();
        int j = 0, cnt = 0, mxCnt = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(s.charAt(i))) {
                cnt++;
            }
            if (i - j + 1 > k) {
                if (set.contains(s.charAt(j)))
                    cnt--;
                j++;
            }
            if (i - j + 1 == k)
                mxCnt = Math.max(mxCnt, cnt);
        }
        return mxCnt;
    }
}
