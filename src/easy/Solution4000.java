package easy;

// 4000. Largest Integer With Given Digit Sum

import java.util.Arrays;

public class Solution4000 {
    public int largestInteger(int n, int s) {
        if (9 * n < s)
            return -1;
        if (s == 0)
            return 0;

        char[] chs = new char[n];
        Arrays.fill(chs, '0');
        for (int i = 0; i < n; i++) {
            if (s < 9) {
                chs[i] += s;
                break;
            }
            chs[i] = '9';
            s -= 9;
        }
        return Integer.parseInt(new String(chs));
    }
}
