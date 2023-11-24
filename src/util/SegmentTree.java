package util;

public class SegmentTree {

    static class TreeNode {
        public int start;
        public int end;
        public int maxVal;
        public TreeNode left;
        public TreeNode right;
        public int lazyTag;
        public int lazyVal;

        public TreeNode(int start, int end, int val, TreeNode l, TreeNode r) {
            this.start = start;
            this.end = end;
            this.maxVal = val;
            this.left = l;
            this.right = r;
            this.lazyTag = 0;
            this.lazyVal = 0;
        }

        public void pushDown() {
            if (this.lazyTag == 1 && this.left != null) {
                this.left.maxVal = this.lazyVal;
                this.right.maxVal = this.lazyVal;
                this.left.lazyTag = 1;
                this.left.lazyVal = this.lazyVal;
                this.right.lazyTag = 1;
                this.right.lazyVal = this.lazyVal;
                this.lazyTag = 0;
                this.lazyVal = 0;
            }
        }
    }

    int[] nums;
    TreeNode root;
    public SegmentTree(int[] nums) {
        this.nums = nums;
        this.root = buildTree(0, nums.length - 1);
    }

    private TreeNode buildTree(int start, int end) {
        if (start == end)
            return new TreeNode(start, end, nums[start], null, null);
        int mid = start + (end - start) / 2;
        TreeNode left = buildTree(start, mid);
        TreeNode right = buildTree(mid + 1, end);
        return new TreeNode(start, end, Math.max(left.maxVal, right.maxVal), left, right);
    }

    public void updateRange(int l, int r, int val) {
        updateRange(root, l, r, val);
    }

    public void updateAt(int pos, int val) {
        updateRange(root, pos, pos, val);
    }

    private void updateRange(TreeNode root, int l, int r, int val) {
        if (r < root.start || l > root.end)
            return;
        if (l <= root.start && root.end <= r) {
            root.maxVal = val;
            root.lazyVal = val;
            root.lazyTag = 1;
            return;
        }
        if (root.left != null) {
            root.pushDown();
            updateRange(root.left, l, r, val);
            updateRange(root.right, l, r, val);
            root.maxVal = Math.max(root.left.maxVal, root.right.maxVal);
        }
    }

    public int queryRange(int l, int r) {
        return queryRange(root, l, r);
    }

    public int queryAt(int pos) {
        return queryRange(root, pos, pos);
    }

    private int queryRange(TreeNode root, int l, int r) {
        if (r < root.start || root.end < l)
            return Integer.MIN_VALUE;
        if (l <= root.start && root.end <= r)
            return root.maxVal;
        if (root.left != null) {
            root.pushDown();
            int a = queryRange(root.left, l, r);
            int b = queryRange(root.right, l, r);
            root.maxVal = Math.max(root.left.maxVal, root.right.maxVal);
            return Math.max(a, b);
        }
        return root.maxVal;
    }
}
