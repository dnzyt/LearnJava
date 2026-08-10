package medium;

// 2565. Subsequence With the Minimum Score

import java.util.ArrayList;
import java.util.List;

public class Solution2565 {
    public int[] validSequence(String word1, String word2) {
        char[] ss = word1.toCharArray();
        char[] tt = word2.toCharArray();
        int n = word1.length(), m = word2.length();
        int[] suf = new int[n + 1];
        suf[n] = m;
        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && ss[i] == tt[j])
                j--;
            suf[i] = j + 1;
        }
        List<Integer> ans = new ArrayList<>();

        boolean changed = false;
        j = 0;
        for (int i = 0; i < n; i++) {
            if (ss[i] == tt[j] || (!changed && suf[i + 1] <= j + 1)) {
                ans.add(i);
                if (ss[i] != tt[j])
                    changed = true;
                j++;
                if (j == m)
                    return ans.stream().mapToInt(Integer::intValue).toArray();
            }
        }



        return new int[]{};
    }
}
