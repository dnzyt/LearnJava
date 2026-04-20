package hard;

// 1649. Create Sorted Array through Instructions

import java.util.*;

public class Solution1649 {
    private static final int MOD = 1000000007;

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

    public int createSortedArray(int[] instructions) {
        SortedSet<Integer> ss = new TreeSet<>();
        for (int x : instructions)
            ss.add(x);
        List<Integer> s = new ArrayList<>(ss);
        int n = s.size();
        FenwickTree f = new FenwickTree(n + 1);
        int ans = 0;
        int cnt = 0;
        for (int x : instructions) {
            int idx = Collections.binarySearch(s, x);
            ans = (ans + Math.min(f.query(idx), cnt - f.query(idx + 1)) % MOD) % MOD;
            cnt++;
            f.update(idx + 1, 1);
        }
        return ans;
    }
}
