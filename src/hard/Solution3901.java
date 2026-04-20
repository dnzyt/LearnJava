package hard;

// 3901. Good Subsequence Queries

public class Solution3901 {
    private int[] tree;
    private int targetP;
    private int n;

    public int countGoodSubseq(int[] nums, int p, int[][] queries) {
        n = nums.length;
        tree = new int[2 << (32 - Integer.numberOfLeadingZeros(n - 1))];
        targetP = p;
        build(1, 0, n - 1, nums);

        int cntP = 0;
        for (int num : nums)
            if (num % p == 0)
                cntP++;

        int ans = 0;
        for (int[] query : queries) {
            int idx = query[0], val = query[1];
            if (nums[idx] % p == 0)
                cntP--;
            nums[idx] = val;
            if (nums[idx] % p == 0)
                cntP++;
            update(idx, val);
            if (queryAll() == p && (cntP < n || n > 6 || check()))
                ans++;
        }
        return ans;
    }

    private void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            tree[node] = nums[l] % targetP == 0 ? nums[l] : 0;
            return;
        }
        int mid = (l + r) >>> 1;
        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);
        tree[node] = gcd(tree[node * 2], tree[node * 2 + 1]);
    }

    private boolean check() {
        for (int i = 0; i < n; i++) {
            if (gcd(query(0, i - 1), query(i + 1, n - 1)) == targetP)
                return true;
        }
        return false;
    }

    private void update(int idx, int val) {
        update(1, 0, n - 1, idx, val);
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            tree[node] = val % targetP == 0 ? val : 0;
            return;
        }
        int mid = (l + r) >>> 1;
        if (idx <= mid) {
            update(node * 2, l, mid, idx, val);
        } else {
            update(node * 2 + 1, mid + 1, r, idx, val);
        }
        tree[node] = gcd(tree[node * 2], tree[node * 2 + 1]);
    }

    private int queryAll() {
        return tree[1];
    }

    private int query(int ql, int qr) {
        return query(1, 0, n - 1, ql, qr);
    }

    private int query(int node, int l, int r, int ql, int qr) {
        if (ql > qr)
            return 0;
        if (ql <= l && r <= qr)
            return tree[node];
        int mid = (l + r) >>> 1;
        if (qr <= mid)
            return query(node * 2, l, mid, ql, qr);
        if (ql > mid)
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        int left = query(node * 2, l, mid, ql, qr);
        int right = query(node * 2 + 1, mid + 1, r, ql, qr);
        return gcd(left, right);
    }

    private int gcd(int x, int y) {
        while (x != 0) {
            int tmp = x;
            x = y % x;
            y = tmp;
        }
        return y;
    }
}
