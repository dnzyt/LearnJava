package hard;

// 715. Range Module

public class Solution715 {
    class RangeModule {

        private RangeModule left;
        private RangeModule right;
        private int l;
        private int r;
        private int cnt;

        public RangeModule() {
            this.l = 1;
            this.r = (int) 1e9;
        }

        private RangeModule(int l, int r) {
            this.l = l;
            this.r = r;
        }


        public void addRange(int left, int right) {
            if (left <= l && r <= right - 1) {
                cnt = r - l + 1;
            } else {
                int mid = (l + r) >>> 1;
                if (this.left == null)
                    this.left = new RangeModule(l, mid);
                if (this.right == null)
                    this.right = new RangeModule(mid + 1, r);
                if (left <= mid)
                    this.left.addRange(left, right);
                if (right - 1 > mid)
                    this.right.addRange(left, right);
                cnt = this.left.cnt + this.right.cnt;
            }
        }

        public boolean queryRange(int left, int right) {
            int a = query(left, right - 1);
            
            return a == right - left;
        }

        private int query(int left, int right) {
            if (left <= l && r <= right)
                return cnt;
            int mid = (l + r) >>> 1;
            int ans = 0;
            if (left <= mid && this.left != null)
                ans += this.left.query(left, right);
            if (right > mid && this.right != null)
                ans += this.right.query(left, right);
            return ans;
        }

        public void removeRange(int left, int right) {
            if (left <= l && r <= right - 1)
                cnt = 0;
            else {
                int mid = (l + r) >>> 1;
                if (left <= mid && this.left != null)
                    this.left.removeRange(left, right);
                if (right - 1 > mid && this.right != null)
                    this.right.removeRange(left, right);
                cnt = (this.left != null ? this.left.cnt : 0) + (this.right != null ? this.right.cnt : 0);
            }
        }
    }
}
