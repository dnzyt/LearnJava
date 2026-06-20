package util;

public class FenwickTree {
    // 索引0的位置空出来不用
    public int[] c;

    public FenwickTree(int n) {
        // 初始值必须都为0
        this.c = new int[n + 1];
    }

    public void update(int i, int delta) {
        while (i < c.length) {
            this.c[i] += delta;
            i += lowbit(i);
        }
    }

    // 求前缀和[1~i]
    public int query(int i) {
        int res = 0;
        while (i > 0) {
            res += this.c[i];
            i -= lowbit(i);
        }
        return res;
    }


    // 求第k小的值
    public int kth(int k) {
        int pos = 0;
        int p = 1;
        // 找到能跳的最远的2的幂
        while (p * 2 <= c.length)
            p *= 2;

        while (p > 0) {
            int nxt = pos + p;
            if (nxt <= c.length && c[nxt] < k) {
                k -= c[nxt];
                pos = nxt;
            }
            p /= 2;
        }
        return pos + 1;
    }

    private int lowbit(int x) {
        return x & (-x);
    }

}

/* 维护区间最小值
class FenwickTree {
    private int[] tree;
    private int[] nums;

    public FenwickTree(int n) {
        tree = new int[n + 1];
        nums = new int[n + 1];
    }

    public void update(int i, int val) {
        nums[i] = val;
        while (i < tree.length) {
            tree[i] = nums[i];
            int lb = lowbit(i);
            for (int j = 1; j < lb; j <<= 1)
                tree[i] = Math.min(tree[i], tree[i - j]);
            i += lowbit(i);
        }
    }

    public int query(int i, int j) {
        int ans = Integer.MAX_VALUE;
        while (j >= i) {
            ans = Math.min(ans, nums[j]);
            j--;
            for (; j - lowbit(j) >= i; j -= lowbit(j)) {
                ans = Math.min(ans, tree[j]);
            }
        }
        return ans;
    }

    private int lowbit(int i) {
        return i & -i;
    }
}
*/

/* 维护区间最大值
class FenwickTree {
    private int[] tree; // max
    private int[] nums;

    public FenwickTree(int n) {
        tree = new int[n + 1];
        nums = new int[n + 1];
    }

    public void update(int i, int val) {
        nums[i] = val;
        while (i < tree.length) {
            tree[i] = nums[i];
            int lb = lowbit(i);
            for (int j = 1; j < lb; j <<= 1)
                tree[i] = Math.max(tree[i], tree[i - j]);
            i += lowbit(i);
        }
    }

    public int query(int left, int right) {
        int ans = Integer.MIN_VALUE;
        while (left <= right) {
            ans = Math.max(ans, nums[right]);
            right--;
            while (right - lowbit(right) >= left) {
                ans = Math.max(ans, tree[right]);
                right -= lowbit(right);
            }
        }
        return ans;
    }


    private int lowbit(int i) {
        return i & -i;
    }
}
*/