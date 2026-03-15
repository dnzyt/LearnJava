package hard;

// 2569. Handling Sum Queries After Update

import java.util.ArrayList;
import java.util.List;

public class Solution2569 {
    private long[] sum;
    private boolean[] flip;

    private int[] nums1;
    private int[] nums2;

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        this.nums1 = nums1;
        sum = new long[n * 4];
        flip = new boolean[n * 4];
        build(1, n, 1);
        List<Long> ans = new ArrayList<>();
        long total = 0L;
        for (int num : nums2)
            total += num;
        for (int[] q : queries) {
            int op = q[0];
            int l = q[1];
            int r = q[2];
            if (op == 1) {
                update(l + 1, r + 1, 1, n, 1);
            } else if (op == 2) {
                total += l * query(1, n, 1, n, 1);
            } else if (op == 3) {
                ans.add(total);
            }
        }
        return ans.stream().mapToLong(Long::longValue).toArray();
    }

    private void build(int l, int r, int i) {
        if (l == r) {
            sum[i] = nums1[l - 1];
        } else {
            int mid = (l + r) >>> 1;
            build(l, mid, i << 1);
            build(mid + 1, r, i << 1 | 1);
            up(i);
        }
    }

    private void update(int jl, int jr, int l, int r, int i) {
        if (jl <= l && r <= jr) {
            lazy(l, r, i);
        } else {
            down(l, r, i);
            int mid = (l + r) >>> 1;
            if (jl <= mid)
                update(jl, jr, l, mid, i << 1);
            if (jr > mid)
                update(jl, jr, mid + 1, r, i << 1 | 1);
            up(i);
        }
    }

    private long query(int jl, int jr, int l, int r, int i) {
        if (jl <= l && r <= jr) {
            return sum[i];
        } else {
            down(l, r, i);
            int mid = (l + r) >>> 1;
            long ans = 0L;
            if (jl <= mid)
                ans += query(jl, jr, l, mid, i << 1);
            if (jr > mid)
                ans += query(jl, jr, mid + 1, r, i << 1 | 1);
            return ans;
        }
    }

    private void down(int l, int r, int i) {
        if (flip[i]) {
            int mid = (l + r) >>> 1;
            lazy(l, mid, i << 1);
            lazy(mid + 1, r, i << 1 | 1);
            flip[i] = false;
        }
    }

    private void lazy(int l, int r, int i) {
        sum[i] = r - l + 1 - sum[i];
        flip[i] = !flip[i];
    }

    private void up(int i) {
        sum[i] = sum[i << 1] + sum[i << 1 | 1];
    }
}
