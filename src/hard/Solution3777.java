package hard;

// 3777. Minimum Deletions to Make Alternating Substring

import util.FenwickTree;

import java.util.ArrayList;
import java.util.List;

public class Solution3777 {
    public int[] minDeletions(String s, int[][] queries) {
        int n = s.length();
        char[] chs = s.toCharArray();
        FenwickTree f = new FenwickTree(n - 1);
        for (int i = 1; i < n; i++) {
            if (chs[i - 1] == chs[i])
                f.update(i, 1);
        }

        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                int i = q[1];
                if (i > 0) {
                    f.update(i, chs[i - 1] == chs[i] ? -1 : 1);
                }
                if (i < n - 1) {
                    f.update(i + 1, chs[i] == chs[i + 1] ? -1 : 1);
                }
                chs[i] ^= 'A' ^ 'B';
            } else {
                int l = q[1], r = q[2];
                ans.add(f.query(r) - f.query(l));
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
