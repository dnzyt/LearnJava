package medium;

// 2904. Shortest and Lexicographically Smallest Beautiful String

public class Solution2904 {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = null;
        int l = 0, cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            cnt += curr - '0';
            while (cnt > k) {
                cnt -= s.charAt(l) - '0';
                l++;
            }
            while (cnt == k) {
                if (ans == null || ans.length() > (i - l + 1) || ans.length() == i - l + 1 && ans.compareTo(s.substring(l, i + 1)) > 0 ) {
                    ans = s.substring(l, i + 1);
                }
                cnt -= s.charAt(l) - '0';
                l++;
            }

        }
        return ans == null ? "" : ans;
    }
}
