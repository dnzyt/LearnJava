package easy;

// 942. DI String Match

import java.util.ArrayList;
import java.util.List;

public class Solution942 {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int lo = 0, hi = n;
        char[] chs = s.toCharArray();
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (chs[i] == 'D') {
                ans[i] = hi--;
            } else {
                ans[i] = lo++;
            }
        }
        ans[n] = lo;
        return ans;
    }
}
