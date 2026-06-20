package hard;

// 3614. Process String with Special Operations II

public class Solution3614 {
    public char processStr(String s, long k) {
        long sz = 0;
        char[] chs = s.toCharArray();
        int n = chs.length;
        for (int i = 0; i < n; i++) {
            if (chs[i] == '*') {
                sz = Math.max(sz - 1, 0);
            } else if (chs[i] == '#') {
                sz *= 2;
            } else if (chs[i] != '%') {
                sz++;
            }
        }
        if (k >= sz)
            return '.';

        for (int i = n - 1; i >= 0; i--) {
            if (chs[i] == '*') {
                sz++;
            } else if (chs[i] == '#') {
                sz /= 2;
                if (k >= sz)
                    k -= sz;
            } else if (chs[i] == '%') {
                k = sz - 1 - k;
            } else {
                if (k == sz - 1)
                    return chs[i];
                sz--;
            }
        }
        return '.';
    }
}
