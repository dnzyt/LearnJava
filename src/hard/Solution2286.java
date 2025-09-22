package hard;


// 2286. Booking Concert Tickets in Groups

public class Solution2286 {

}

class SegmentTree {
    private int[] min;
    private long[] sum;


    public SegmentTree(int n, int m) {
        this.min = new int[2 << (32 - Integer.numberOfLeadingZeros(n))];
        this.sum = new long[2 << (32 - Integer.numberOfLeadingZeros(n))];
    }
    // 把下标i的值增加val
    public void update(int root, int left, int right, int pos, int val) {
        if (left == right) {
            min[root] += val;
            sum[root] += val;
            return;
        }
        int mid = (left + right) >>> 1;
        if (pos <= mid)
            update(root * 2, left, mid, pos, val);
        else
            update(root * 2 + 1, mid + 1, right, pos, val);
        min[root] = Math.min(min[root * 2], min[root * 2 + 1]);
        sum[root] = sum[root * 2] + sum[root * 2 + 1];
    }

    // 在maxRow之前的row中，找到第一个小于等于x的位置
    public int findFirst(int root, int left, int right, int x, int maxRow) {
        if (min[root] > x) return -1;
        if (left == right) return left;
        int mid = (left + right) >>> 1;
        if (min[root * 2] <= x) return findFirst(root * 2, left, mid, x, maxRow);
        if (maxRow > mid) return findFirst(root * 2 + 1, mid + 1, right, x, maxRow);
        return -1;
    }

    public long querySum(int root, int left, int right, int l, int r) {
        if (l <= left && right <= r) return sum[root];
        int mid = (left + right) >>> 1;
        long ans = 0;
        if (mid >= l)
            ans += querySum(root * 2, left, mid, l, r);
        if (mid < r)
            ans += querySum(root * 2 + 1, mid + 1, right, l, r);
        return ans;
    }
}

class BookMyShow {
    private SegmentTree st;
    private int n;
    private int m;
    public BookMyShow(int n, int m) {
        st = new SegmentTree(n, m);
        this.n = n;
        this.m = m;

    }

    public int[] gather(int k, int maxRow) {

        int r = st.findFirst(1, 0, n - 1, m - k, maxRow);
        if (r == -1) return new int[0];
        int c = (int) st.querySum(1, 0, n - 1, r, r);
        st.update(1, 0, n - 1, r, k);
        return new int[] {r, c};
    }

    public boolean scatter(int k, int maxRow) {
        long vol = st.querySum(1, 0, n - 1, 0, maxRow);
        if ((long) m * (maxRow + 1) - k < vol) return false;
        int r = st.findFirst(1, 0, n - 1, m - 1, maxRow);
        while (k > 0) {
            int left = Math.min(m - (int) st.querySum(1, 0, n - 1, r, r), k);
            st.update(1, 0, n - 1, r, left);
            r++;
            k -= left;
        }

        return true;
    }
}


