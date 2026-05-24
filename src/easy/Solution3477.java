package easy;

// 3477. Fruits Into Baskets II

public class Solution3477 {

    private int[] mx;

    private void build(int o, int l, int r, int[] baskets) {
        if (l == r) {
            mx[o] = baskets[l];
            return;
        }
        int mid = (l + r) >>> 1;
        build(o * 2, l, mid, baskets);
        build(o * 2 + 1, mid + 1, r, baskets);
        mx[o] = Math.max(mx[o * 2], mx[o * 2 + 1]);
    }

    private void update(int o, int l, int r, int idx, int val) {
        if (l == r) {
            mx[o] = val;
            return;
        }
        int mid = (l + r) >>> 1;
        if (idx <= mid)
            update(o * 2, l, mid, idx, val);
        else
            update(o * 2 + 1, mid + 1, r, idx, val);
        mx[o] = Math.max(mx[o * 2], mx[o * 2 + 1]);
    }

    private int findFirst(int o, int l, int r, int val) {
        if (mx[o] < val)
            return -1;
        if (l == r)
            return l;
        int mid = (l + r) >>> 1;
        int idx = findFirst(o * 2, l, mid, val);
        if (idx < 0)
            idx = findFirst(o * 2 + 1, mid + 1, r, val);
        return idx;
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        mx = new int[2 << (32 - Integer.numberOfLeadingZeros(n - 1))];
        build(1, 0, n - 1, baskets);
        int ans = 0;
        for (int f : fruits) {
            int idx = findFirst(1, 0, n - 1, f);
            if (idx < 0)
                ans++;
            else {
                update(1, 0, n - 1, idx, -1);
            }
        }
        return ans;
    }
}
