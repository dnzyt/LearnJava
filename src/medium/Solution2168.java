package medium;

// 2168. Unique Substrings With Equal Digit Frequency

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2168 {
    public int equalDigitFrequency(String s) {
        int n = s.length();
        int base = 499;
        Set<Long> set = new HashSet<>();
        int[][] cnt = new int[n + 1][];
        cnt[0] = new int[10];
        for (int i = 0; i < n; i++) {
            cnt[i + 1] = Arrays.copyOf(cnt[i], 10);
            cnt[i + 1][s.charAt(i) - '0']++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int freq = cnt[i + 1][s.charAt(j) - '0'] - cnt[j][s.charAt(j) - '0'];
                boolean found = true;
                Long h = base + (long) (s.charAt(j) - '0');
                for (int k = j + 1; k <= i; k++) {
                    int ch = s.charAt(k) - '0';
                    if (freq != cnt[i + 1][ch] - cnt[j][ch]) {
                        found = false;
                        break;
                    }
                    h = h * base + ch;
                }
                if (found)
                    set.add(h);

            }
        }
        return set.size();
    }
}
