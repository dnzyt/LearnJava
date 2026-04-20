package medium;

// 1626. Best Team With No Conflicts

import java.util.*;

public class Solution1626 {
    // 树状数组维护最大值
    class FenwickTree {
        private int[] tree;

        public FenwickTree(int n) {
            tree = new int[n + 1];
        }

        public void update(int i, int mx) {
            while (i < tree.length) {
                tree[i] = Math.max(tree[i], mx);
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int ans = 0;
            while (i > 0) {
                ans = Math.max(ans, tree[i]);
                i -= lowbit(i);
            }
            return ans;
        }

        private int lowbit(int i) {
            return i & -i;
        }
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int u = 0;
        int[][] pairs = new int[scores.length][];
        for (int i = 0; i < scores.length; i++) {
            u = Math.max(u, ages[i]);
            pairs[i] = new int[]{ages[i], scores[i]};
        }
        Arrays.sort(pairs, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        FenwickTree f = new FenwickTree(u + 1);
        int ans = 0;
        for (int i = 0; i < pairs.length; i++) {
            int age = pairs[i][0];
            int score = pairs[i][1];
            int mx = f.query(age + 1) + score;
            f.update(age + 1, mx);
        }
        return f.query(u + 1);
    }
}
