package medium;

// 307. Range Sum Query - Mutable

public class Solution307 {
    class NumArray {
        private int[] nums;
        private int[] tree;

//        public NumArray(int[] nums) {
//            int n = nums.length;
//            this.nums = new int[n];
//            this.tree = new int[n + 1];
//            for (int i = 0; i < n; i++)
//                update(i, nums[i]);
//        }

        public NumArray(int[] nums) {
            int n = nums.length;
            this.nums = nums;
            tree = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                tree[i] += nums[i - 1];
                int nxt = i + (i & -i);
                if (nxt <= n)
                    tree[nxt] += tree[i];
            }
        }

        public void update(int index, int val) {
            int delta = val - nums[index];
            for (int i = index + 1; i < tree.length; i += i & -i)
                tree[i] += delta;
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return presum(right + 1) - presum(left);
        }

        private int presum(int i) {
            int ans = 0;
            while (i > 0) {
                ans += tree[i];
                i -= i & -i;
            }
            return ans;
        }
    }
}
