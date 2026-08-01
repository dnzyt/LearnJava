package medium;

// 3016. Minimum Number of Pushes to Type Word II

import java.util.Arrays;
import java.util.Collections;

public class Solution3016 {
    public int minimumPushes(String word) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray())
            cnt[c - 'a']++;
        Arrays.sort(cnt);
        int ans = 0;
        for (int i = 0; i < 26; i++)
            ans += cnt[25 - i] * (i / 8 + 1);
        return ans;
    }
}
