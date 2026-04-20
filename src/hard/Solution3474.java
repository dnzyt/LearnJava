package hard;

// 3474. Lexicographically Smallest Generated String

import java.util.Arrays;

public class Solution3474 {
    public String generateString(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        char[] ans = new char[n + m - 1];
        Arrays.fill(ans, '?');
        for (int i = 0; i < n; i++) {
            char ch = str1.charAt(i);
            if (ch == 'F')
                continue;
            for (int j = 0; j < m; j++) {
                if (ans[i + j] != '?' && ans[i + j] != str2.charAt(j))
                    return "";
                ans[i + j] = str2.charAt(j);
            }
        }
        char[] oldAns = ans.clone();
        for (int i = 0; i < ans.length; i++)
            if (ans[i] == '?')
                ans[i] = 'a';
        for (int i = 0; i < n; i++) {
            char ch = str1.charAt(i);
            if (ch == 'T')
                continue;
            if (str2.equals(new String(ans, i, m))) {
                boolean ok = false;
                for (int j = m - 1; j >= 0; j--) {
                    if (oldAns[i + j] == '?') {
                        ans[i + j] = 'b';
                        ok = true;
                        break;
                    }
                }
                if (!ok)
                    return "";
            }
        }
        return new String(ans);
    }
}
