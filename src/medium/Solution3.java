package medium;

// 3. Longest Substring Without Repeating Characters

import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray();
        int[] count = new int[128];
        int ans = 0;
        int i = 0;
        for (int j = 0; j < ss.length; j++) {
            count[ss[j]] ++;
            while (count[ss[j]] > 1) {
                count[ss[i]] --;
                i ++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

}
