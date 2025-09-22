package util;


// 支持单点更新，维护区间最大值
// 线段树可以快速找到区间内的最大值
// 也可以快速找到从左往右第一个大于等于X的值
public class SimpleSegmentTree {

    private int[] tree; // 根从1开始, 0不用
    private int[] nums;

    public SimpleSegmentTree(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        this.tree = new int[2 << (32 - Integer.numberOfLeadingZeros(n - 1))];
        buildTree(1, 0, n - 1, nums);
    }


    // [l, r]区间的最大值
    public int query(int l, int r) {
        return query(1, l, r);
    }

    public int findFirstInRange(int l, int r, int x) {
        return findFirstInRange(1, 0, nums.length - 1, l, r, x);
    }

    private int findFirstInRange(int root, int left, int right, int l, int r, int x) {
        if (tree[root] < x) return -1;
        if (left == right) {
            if (left >= l && left <= r) return left;
            return -1;
        }
        int mid = (left + right) >>> 1;
        int lroot = findFirstInRange(root * 2, left, mid, l, r, x);
        if (lroot == -1) {
            return findFirstInRange(root * 2 + 1, mid + 1, right, l, r, x);
        }
        return lroot;

    }

    // 找到第一个大于等于x的值并且更新为newVal
    public int findFirstAndUpdate(int x, int newVal) {
        return findFirstAndUpdate(1, 0, nums.length - 1, x, newVal);
    }

    private int findFirstAndUpdate(int root, int left, int right, int x, int newVal) {
        if (tree[root] < x) return -1;
        if (left == right) {
            tree[root] = newVal;
            return left;
        }
        int mid = (left + right) >>> 1;
        int i = findFirstAndUpdate(root * 2, left, mid, x, newVal);
        if (i == -1) {
            i = findFirstAndUpdate(root * 2 + 1, mid + 1, right, x, newVal);
        }
        tree[root] = Math.max(tree[root * 2], tree[root * 2 + 1]);
        return i;
    }

    private int query(int root, int left, int right) {
        if (left > right) return Integer.MIN_VALUE;
        if (left == right) {
            return tree[root];
        }
        int mid = (left + right) >>> 1;
        int l = query(root * 2, left, mid);
        int r = query(root * 2 + 1, mid + 1, right);
        return Math.max(l, r);
    }

    private void buildTree(int root, int left, int right, int[] nums) {
        if (left == right) {
            tree[root] = nums[left];
            return;
        }
        int mid = (left + right) >>> 1;
        buildTree(root * 2, left, mid, nums);
        buildTree(root * 2 + 1, mid + 1, right, nums);
        tree[root] = Math.max(tree[root * 2], tree[root * 2 + 1]);
    }


}
