package medium;

// 3499. Maximize Active Section with Trade I

public class Solution3499 {
    public int maxActiveSectionsAfterTrade(String s) {
        char[] chs = s.toCharArray();
        int n = s.length();
        int mx = 0;
        int cnt1 = 0;
        int pre = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt++;
            if (i == n - 1 || chs[i] != chs[i + 1]) {
                if (chs[i] == '1') {
                    cnt1 += cnt;
                } else if (chs[i] == '0') {
                    mx = Math.max(mx, cnt + pre);
                    pre = cnt;
                }
                cnt = 0;
            }
        }
        return cnt1 + mx;

    }
}
