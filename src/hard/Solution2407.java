package hard;

// 2407. Longest Increasing Subsequence II

public class Solution2407 {
    private int[] mx;

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

    private int query(int o, int l, int r, int L, int R) {
        if (L <= l && r <= R)
            return mx[o];
        int mid = (l + r) >>> 1;
        int res = 0;
        if (L <= mid)
            res = query(o * 2, l, mid, L, R);
        if (R > mid)
            res = Math.max(res, query(o * 2 + 1, mid + 1, r, L, R));
        return res;
    }


    public int lengthOfLIS(int[] nums, int k) {
        int u = 0;
        for (int num : nums)
            u = Math.max(u, num);
        // 找到最近的比u大的2的次方，比如10的话就是16
        // 找到之后乘以2
        int sz = 2 << (32 - Integer.numberOfLeadingZeros(u));
        mx = new int[sz];
        for (int num : nums) {
            if (num == 1)
                update(1, 1, u, 1, 1);
            else
                update(1, 1, u, num, query(1, 1, u, Math.max(num - k, 1), num - 1) + 1);
        }
        return mx[1];
    }
}
