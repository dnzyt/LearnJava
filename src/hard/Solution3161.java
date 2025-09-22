package hard;

// 3161. Block Placement Queries

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

//线段树维护区间最大值
//treeset用来快速找到当前值的前驱和后继

public class Solution3161 {
    private int[] t;
    public List<Boolean> getResults(int[][] queries) {
        int m = 0;
        for (int[] q : queries) {
            m = Math.max(m, q[1]);
        }
        m++; // 整个数组的长度
        TreeSet<Integer> set = new TreeSet<>(List.of(0, m));
        int size = 2 << (32 - Integer.numberOfLeadingZeros(m));
        t = new int[size];
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            int x = q[1];
            int pre = set.floor(x - 1);
            if (q[0] == 1) {
                int nxt = set.ceiling(x);
                set.add(x);
                update(1, 0, m-1, x, x - pre);
                update(1, 0, m-1, nxt, nxt - x);
            } else {
                int mx = query(1, 0, m-1, 0, pre);
                ans.add(Math.max(mx, x - pre) >= q[2]);
            }
        }
        return ans;
    }

    private void update(int root, int left, int right, int i, int val) {
        if (left == right) {
            t[root] = val;
            return;
        }
        int mid = (left + right) >>> 1;
        if (i <= mid)
            update(root * 2, left, mid, i, val);
        else
            update(root * 2 + 1, mid + 1, right, i, val);
        t[root] = Math.max(t[root * 2], t[root * 2 + 1]);
    }

    private int query(int root, int left, int right, int l, int r) {
        if (l <= left && right <= r) return t[root];
        int mid = (left + right) >>> 1;
        int ans = 0;
        if (l <= mid)
            ans = Math.max(ans, query(root * 2, left, mid, l, r));
        if (mid < r)
            ans = Math.max(ans, query(root * 2 + 1, mid + 1, right, l, r));
        return ans;
    }
}
