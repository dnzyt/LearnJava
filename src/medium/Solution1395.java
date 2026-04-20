package medium;

// 1395. Count Number of Teams

import java.util.*;

public class Solution1395 {
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

    public int numTeams(int[] rating) {
        int n = rating.length;
        SortedSet<Integer> ss = new TreeSet<>();
        for (int r : rating)
            ss.add(r);
        List<Integer> s = new ArrayList<>(ss);

        FenwickTree f = new FenwickTree(s.size() + 1);
        int[] leftSmaller = new int[n];
        int[] leftBigger = new int[n];
        int[] rightSmaller = new int[n];
        int[] rightBigger = new int[n];

        for (int i = 0; i < n; i++) {
            int idx = Collections.binarySearch(s, rating[i]);
            leftSmaller[i] = f.query(idx);
            f.update(idx + 1, 1);
            leftBigger[i] = i + 1 - f.query(idx + 1);
        }
        f = new FenwickTree(s.size() + 1);
        for (int i = n - 1; i >= 0; i--) {
            int idx = Collections.binarySearch(s, rating[i]);
            rightSmaller[i] = f.query(idx);
            f.update(idx + 1, 1);
            rightBigger[i] = n - i - f.query(idx + 1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans += leftSmaller[i] * rightBigger[i] + rightSmaller[i] * leftBigger[i];
        return ans;
    }
}
