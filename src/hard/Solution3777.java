package hard;

// 3777. Minimum Deletions to Make Alternating Substring

import java.util.ArrayList;
import java.util.List;

public class Solution3777 {
    class FenwickTree {
        private int[] tree;

        public FenwickTree(int n) {
            tree = new int[n + 1];
        }

        public void update(int i, int delta) {
            while (i < tree.length) {
                tree[i] += delta;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int ans = 0;
            while (i > 0) {
                ans += tree[i];
                i -= lowbit(i);
            }
            return ans;
        }

        private int lowbit(int i) {
            return i & -i;
        }
    }


    public int[] minDeletions(String s, int[][] queries) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        FenwickTree f = new FenwickTree(n + 1);

        for (int i = 1; i < n; i++) {
            if (chs[i] == chs[i - 1])
                f.update(i + 1, 1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                int idx = query[1];
                if (idx == 0) {
                    f.update(1, chs[0] == chs[1] ? -1 : 1);
                } else if (idx == n - 1) {
                    f.update(n - 1, chs[n - 2] == chs[n - 1] ? -1 : 1);
                } else {
                    f.update(idx, chs[idx - 1] == chs[idx] ? -1 : 1);
                    f.update(idx + 1, chs[idx] == chs[idx + 1] ? -1 : 1);
                }
                chs[idx] = chs[idx] == 'A' ? 'B' : 'A';
            } else if (query[0] == 2) {
                int l = query[1], r = query[2];
                ans.add(f.query(r + 1) - f.query(l + 1));
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
