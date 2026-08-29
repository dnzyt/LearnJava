package hard;

// 3721. Longest Balanced Subarray II

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3721 {

    private static final class Node {
        public int min;
        public int max;
        public int lazy;
    }

    private static final class LazySegmentTree {

        private final Node[] tree;
        private final int n;

        public LazySegmentTree(int n) {
            this.n = n;
            tree = new Node[2 << (32 - Integer.numberOfLeadingZeros(n - 1))];
            Arrays.setAll(tree, i -> new Node());
        }

        public void update(int l, int r, int val) {
            updateRange(1, 0, n - 1, l, r, val);
        }

        private void updateRange(int node, int left, int right, int ql, int qr, int val) {
            if (right < ql || left > qr)
                return;
            if (ql <= left && right <= qr) {
                apply(node, val);
                return;
            }
            pushDown(node);
            int mid = (left + right) >>> 1;
            if (ql <= mid)
                updateRange(node * 2, left, mid, ql, qr, val);
            if (qr > mid)
                updateRange(node * 2 + 1, mid + 1, right, ql, qr, val);
            maintain(node);
        }

        public int findFirst(int ql, int qr, int val) {
            return findFirst(1, 0, n - 1, ql, qr, val);
        }

        private int findFirst(int node, int left, int right, int ql, int qr, int val) {
            Node curr = tree[node];
            if (curr.max < val || curr.min > val)
                return -1;
            if (right < ql || left > qr)
                return -1;
            if (left == right)
                return left;
            pushDown(node);
            int mid = (left + right) >>> 1;
            int idx = findFirst(node * 2, left, mid, ql, qr, val);
            if (idx == -1)
                idx = findFirst(node * 2 + 1, mid + 1, right, ql, qr, val);
            return idx;
        }

        private void pushDown(int node) {
            Node curr = tree[node];
            if (curr.lazy == 0)
                return;
            apply(node * 2, curr.lazy);
            apply(node * 2 + 1, curr.lazy);
            curr.lazy = 0;
        }

        private void apply(int node, int val) {
            Node curr = tree[node];
            curr.max += val;
            curr.min += val;
            curr.lazy += val;
        }

        private void maintain(int node) {
            tree[node].max = Math.max(tree[node * 2].max, tree[node * 2 + 1].max);
            tree[node].min = Math.min(tree[node * 2].min, tree[node * 2 + 1].min);
        }
    }


    public int longestBalanced(int[] nums) {
        int n = nums.length;
        LazySegmentTree t = new LazySegmentTree(n + 1);
        int ans = 0, presum = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int v = nums[i - 1] % 2 == 0 ? -1 : 1;
            Integer j = cnt.get(nums[i - 1]);
            if (j == null) {
                presum += v;
                t.update(i, n, v);
            } else {
                t.update(j, i - 1, -v);
            }
            cnt.put(nums[i - 1], i);
            int l = t.findFirst(0, i - 1 - ans, presum);
            if (l >= 0)
                ans = i - l;
        }
        return ans;
    }
}
