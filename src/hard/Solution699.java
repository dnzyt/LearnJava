package hard;

// 699. Falling Squares

import java.util.*;

public class Solution699 {

    private int[] maxx;
    private int[] change;
    private boolean[] toUpdate;

    // Lazy线段树，区间更新，维护最大值
    public List<Integer> fallingSquares(int[][] positions) {
        SortedSet<Integer> pos = new TreeSet<>();
        for (int[] p : positions) {
            int left = p[0];
            int right = p[0] + p[1] - 1;
            pos.add(left);
            pos.add(right);
        }
        List<Integer> indices = new ArrayList<>();
        indices.add(-1);
        for (int x : pos)
            indices.add(x);
        int n = pos.size();
        maxx = new int[n * 4];
        change = new int[n * 4];
        toUpdate = new boolean[n * 4];
        List<Integer> ans = new ArrayList<>();
        int highest = 0;
        for (int[] p : positions) {
            int start = Collections.binarySearch(indices, p[0]);
            int end = Collections.binarySearch(indices, p[0] + p[1] - 1);
            int h = query(start, end, 1, n, 1);
            highest = Math.max(highest, h + p[1]);
            ans.add(highest);
            update(start, end, h + p[1], 1, n, 1);
        }
        return ans;
    }

    private int query(int jl, int jr, int l, int r, int i) {
        if (jl <= l && r <= jr) {
            return maxx[i];
        } else {
            down(i);
            int mid = (l + r) >>> 1;
            int ans = 0;
            if (jl <= mid) {
                ans = Math.max(ans, query(jl, jr, l, mid, i << 1));
            }
            if (jr > mid) {
                ans = Math.max(ans, query(jl, jr, mid + 1, r, i << 1 | 1));
            }
            return ans;
        }
    }

    private void update(int jl, int jr, int val, int l, int r, int i) {
        if (jl <= l && r <= jr) {
            lazy(i, val);
        } else {
            down(i);
            int mid = (l + r) >>> 1;
            if (jl <= mid) {
                update(jl, jr, val, l, mid, i << 1);
            }
            if (jr > mid) {
                update(jl, jr, val, mid + 1, r, i << 1 | 1);
            }
            up(i);
        }
    }

    private void down(int i) {
        if (toUpdate[i]) {
            lazy(i << 1, change[i]);
            lazy(i << 1 | 1, change[i]);
            toUpdate[i] = false;
        }
    }

    private void up(int i) {
        maxx[i] = Math.max(maxx[i << 1], maxx[i << 1 | 1]);
    }

    private void lazy(int i, int val) {
        maxx[i] = val;
        change[i] = val;
        toUpdate[i] = true;
    }
}
