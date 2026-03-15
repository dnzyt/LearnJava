package medium;

// 3863. Minimum Operations to Sort a String

import java.util.Arrays;

public class Solution3863 {
    // 分类讨论
    public int minOperations(String s) {
        int n = s.length();
        if (n == 1)
            return 0;
        char[] chs = s.toCharArray();
        if (n == 2)
            return chs[0] > chs[1] ? -1 : 0;
        char mn = 'z', mx = 'a';
        for (char c : chs) {
            mn = c < mn ? c : mn;
            mx = c > mx ? c : mx;
        }
        Arrays.sort(chs);
        String ss = new String(chs);
        if (ss.equals(s))
            return 0;

        char[] t = s.toCharArray();
        Arrays.sort(t, 0, n - 1);
        String sortedPrefix = new String(t, 0, n - 1);
        t = s.toCharArray();
        Arrays.sort(t, 1, n);
        String sortedSuffix = new String(t, 1, n - 1);
        chs = s.toCharArray();
        if (chs[0] == mn || chs[n - 1] == mx)
            return 1;
        if (s.substring(0, n - 1).equals(sortedPrefix)) {
            return chs[n - 1] == mn ? 2 : 1;
        }
        if (s.substring(1, n).equals(sortedSuffix)) {
            return chs[0] == mx ? 2 : 1;
        }
        if (chs[0] == mn || chs[n - 1] == mx)
            return 1;
        Arrays.sort(chs, 0, n - 1);
        Arrays.sort(chs, 1, n);
        if (ss.equals(new String(chs)))
            return 2;
        chs = s.toCharArray();
        Arrays.sort(chs, 1, n);
        Arrays.sort(chs, 0, n - 1);
        if (ss.equals(new String(chs)))
            return 2;
        return 3;
    }
}
