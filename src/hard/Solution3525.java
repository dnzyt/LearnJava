package hard;

// 3525. Find X Value of Array II

public class Solution3525 {
    class SegmentTree {
        private record Data(int mul, int[] cnt) {}

        private int k;
        private int n;
        private Data[] tree;

        private Data mergeData(Data a, Data b) {
            int mul = a.mul * b.mul % k;
            int[] cnt = a.cnt.clone();
            for (int i = 0; i < k; i++) {
                cnt[i * a.mul % k] += b.cnt[i];
            }
            return new Data(mul, cnt);
        }

        private Data newData(int val) {
            int mul = val % k;
            int[] cnt = new int[k];
            cnt[mul] = 1;
            return new Data(mul, cnt);
        }

        public SegmentTree(int[] a, int k) {
            this.k = k;
            this.n = a.length;
            tree = new Data[2 << (32 - Integer.numberOfLeadingZeros(n - 1))];
            build(1, 0, n - 1, a);
        }

        private void build(int node, int left, int right, int[] a) {
            if (left == right) {
                tree[node] = newData(a[left]);
                return;
            }
            int mid = (left + right) >>> 1;
            build(node * 2, left, mid, a);
            build(node * 2 + 1, mid + 1, right, a);
            tree[node] = mergeData(tree[node * 2], tree[node * 2 + 1]);
        }

        public int query(int l, int r, int x) {
            Data d = query(1, 0, n - 1, l, r);
            return d.cnt[x];
        }

        private Data query(int node, int left, int right, int l, int r) {
            if (l <= left && right <= r) {
                return tree[node];
            }
            int mid = (left + right) >>> 1;
            if (r <= mid)
                return query(node * 2, left, mid, l, r);
            if (l > mid)
                return query(node * 2 + 1, mid + 1, right, l, r);
            Data dl = query(node * 2, left, mid, l, r);
            Data dr = query(node * 2 + 1, mid + 1, right, l, r);
            return mergeData(dl, dr);
        }

        public void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }

        private void update(int node, int left, int right, int idx, int val) {
            if (left == right) {
                tree[node] = newData(val);
                return;
            }
            int mid = (left + right) >>> 1;
            if (idx <= mid)
                update(node * 2, left, mid, idx, val);
            else
                update(node * 2 + 1, mid + 1, right, idx, val);
            tree[node] = mergeData(tree[node * 2], tree[node * 2 + 1]);
        }

    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int[] ans = new int[queries.length];
        SegmentTree seg = new SegmentTree(nums, k);
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0], val = queries[i][1], start = queries[i][2], x = queries[i][3];
            seg.update(idx, val);
            ans[i] = seg.query(start, nums.length - 1, x);
        }

        return ans;
    }
}
