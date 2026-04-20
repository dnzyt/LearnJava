package medium;

// 1409. Queries on a Permutation With Key

import java.util.ArrayList;
import java.util.List;

public class Solution1409 {
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

    public int[] processQueries(int[] queries, int m) {
        int[] pos = new int[m + 1];
        FenwickTree f = new FenwickTree(m * 2 + 2);
        for (int i = 1; i <= m; i++) {
            pos[i] = i + m;
            f.update(i + m, 1);
        }
        List<Integer> ans = new ArrayList<>();
        int i = m;
        for (int query : queries) {
            int idx = pos[query];
            ans.add(f.query(idx) - 1);
            f.update(idx, -1);
            f.update(m, 1);
            pos[query] = m;
            m--;
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
