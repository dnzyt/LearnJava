package hard;

// 2179. Count Good Triplets in an Array

public class Solution2179 {

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

        private int query(int i) {
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

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[nums1[i]] = i;
        }
        FenwickTree f = new FenwickTree(n + 1);
        long ans = 0l;
        for (int i = 0; i < n; i++) {
            int y = p[nums2[i]];
            long left = (long) f.query(y);
            ans += left * (n - 1 - y - (i - left));
            f.update(y + 1, 1);
        }
        return ans;
    }
}
