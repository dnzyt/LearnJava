package medium;

// 3412. Find Mirror Score of a String

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution3412 {
    public long calculateScore(String s) {
        Deque<Integer>[] sts = new ArrayDeque[26];
        Arrays.setAll(sts, k -> new ArrayDeque<>());
        char[] chs = s.toCharArray();
        int n = s.length();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int c = chs[i] - 'a';
            int mirror = 25 - (chs[i] - 'a');
            if (!sts[mirror].isEmpty()) {
                ans += i - sts[mirror].pop();
            } else {
                sts[c].push(i);
            }
        }
        return ans;
    }
}
