package medium;

// 1657. Determine if Two Strings Are Close

import java.util.Arrays;

public class Solution1657 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        int mask1 = 0;
        int mask2 = 0;
        for (int i = 0; i < word1.length(); i++) {
            cnt1[word1.charAt(i) - 'a']++;
            cnt2[word2.charAt(i) - 'a']++;
            mask1 |= (1 << (word1.charAt(i) - 'a'));
            mask2 |= (1 << (word2.charAt(i) - 'a'));
        }
        if (mask1 != mask2)
            return false;
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);

        return Arrays.equals(cnt1, cnt2);
    }
}
