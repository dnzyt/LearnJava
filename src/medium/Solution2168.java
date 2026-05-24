package medium;

// 2168. Unique Substrings With Equal Digit Frequency

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2168 {
    private static final int BASE = 499;

    public int equalDigitFrequency(String s) {
        char[] chs = s.toCharArray();
        Set<Long> ans = new HashSet<Long>();
        int n = s.length();
        int[][] cnt = new int[n + 1][];
        cnt[0] = new int[10];
        for (int i = 0; i < n; i++) {
            cnt[i + 1] = Arrays.copyOf(cnt[i], 10);
            cnt[i + 1][chs[i] - '0']++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int freq = cnt[i + 1][chs[i] - '0'] - cnt[j][chs[i] - '0'];
                boolean found = true;
                long hash = 0l;
                for (int k = j; k <= i; k++) {
                    if (cnt[i + 1][chs[k] - '0'] - cnt[j][chs[k] - '0'] != freq) {
                        found = false;
                        break;
                    }
                    // 0 -> 1
                    // 1 -> 2
                    // 2 -> 3
                    // ...
                    hash = hash * BASE + (chs[k] - '0' + 1);
                }
                if (found)
                    ans.add(hash);
            }
        }
        return ans.size();
    }
}
