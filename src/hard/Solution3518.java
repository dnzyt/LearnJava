package hard;

// 3518. Smallest Palindromic Rearrangement II

public class Solution3518 {
    public String smallestPalindrome(String s, int k) {
        int[] cnt = new int[26];
        int n = s.length(), m = s.length() / 2;
        for (int i = 0; i < m; i++)
            cnt[s.charAt(i) - 'a']++;
        if (perm(m, cnt, k) < k)
            return "";
        char[] left = new char[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < cnt.length; j++) {
                if (cnt[j] == 0)
                    continue;
                cnt[j]--;
                int p = perm(m - (i + 1), cnt, k);
                if (p >= k) {
                    left[i] = (char) ('a' + j);
                    break;
                }
                k -= p;
                cnt[j]++;
            }
        }
        StringBuilder sb = new StringBuilder(n);
        sb.append(left);
        if (n % 2 > 0)
            sb.append(s.charAt(m));
        for (int i = m - 1; i >= 0; i--)
            sb.append(left[i]);
        return sb.toString();
    }

    private int combo(int n, int m, int k) {
        m = Math.min(m, n - m);
        long res = 1L;
        for (int i = 1; i <= m; i++) {
            res = res * (n + 1 - i) / i;
            if (res >= k)
                return k;
        }
        return (int) res;
    }

    private int perm(int sz, int[] cnt, int k) {
        long res = 1L;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 0)
                continue;
            res *= combo(sz, cnt[i], k);
            if (res >= k)
                return k;
            sz -= cnt[i];
        }
        return (int) res;
    }
}
