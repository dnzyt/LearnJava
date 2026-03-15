package hard;

// 2276. Count Integers in Intervals

public class Solution2276 {

    class CountIntervals {
        private int cnt;
        private int l, r;
        private CountIntervals left, right;

        public CountIntervals() {
            l = 1;
            r = (int) 1e9;
        }

        private CountIntervals(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public void add(int left, int right) {
            if (r - l + 1 == cnt)
                return;
            if (left <= l && r <= right) {
                cnt = r - l + 1;
                return;
            }
            int mid = (l + r) >>> 1;
            if (this.left == null)
                this.left = new CountIntervals(l, mid);
            if (this.right == null)
                this.right = new CountIntervals(mid + 1, r);
            if (left <= mid)
                this.left.add(left, right);
            if (right > mid)
                this.right.add(left, right);
            cnt = this.left.count() + this.right.count();
        }

        public int count() {
            return cnt;
        }
    }
}
