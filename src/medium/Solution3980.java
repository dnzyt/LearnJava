package medium;

// 3980. Minimum Operations to Transform Binary String

public class Solution3980 {
    // 贪心，遇到1的时候跟右边的合并
    public int minOperations(String s1, String s2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int n = s1.length();
        int ans = 0;
        if (n == 1 && chs1[0] == '1' && chs2[0] == '0')
            return -1;
        for (int i = 0; i < n; i++) {
            if (chs1[i] == chs2[i])
                continue;
            if (chs1[i] == '0') {
                ans++;
            } else {
                if (i < n - 1) {
                    if (chs1[i + 1] == '1') {
                        chs1[i + 1] = '0';
                        ans++;
                    } else {
                        ans += 2;
                    }
                } else
                    ans += 2;
            }
        }
        return ans;
    }
}
