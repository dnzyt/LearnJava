package hard;

// 3485. Longest Common Prefix of K Strings After Removal

import java.util.Arrays;
import java.util.Comparator;

public class Solution3485 {
    public int[] longestCommonPrefix(String[] words, int k) {
        int n = words.length;
        if (k >= n)
            return new int[n];
        Integer[] ids = new Integer[n];
        Arrays.setAll(ids, i -> i);
        Arrays.sort(ids, Comparator.comparing(i -> words[i]));
        int mx = -1, mx2 = -1, mxIndex = -1;
        int[] ans = new int[n];
        for (int i = 0; i < n - k + 1; i++) {
            String a = words[ids[i]], b = words[ids[i + k - 1]];
            int lcp = lcp(a, b);
            if (mx < lcp) {
                mx2 = mx;
                mx = lcp;
                mxIndex = i;
            } else if (mx2 < lcp)
                mx2 = lcp;
        }
        Arrays.fill(ans, mx);
        for (int i = mxIndex; i < mxIndex + k; i++)
            ans[ids[i]] = mx2;
        return ans;
    }

    private int lcp(String a, String b) {
        int l = Math.min(a.length(), b.length());
        for (int i = 0; i < l; i++) {
            if (a.charAt(i) != b.charAt(i))
                return i;
        }
        return l;
    }
}
