package hard;

// 2926. Maximum Balanced Subsequence Sum

import java.util.Arrays;

public class Solution2926 {

    //    class FenwickTree {
//        private long[] tree;
//
//        public FenwickTree(int n) {
//            tree = new long[n + 1];
//            Arrays.fill(tree, Long.MIN_VALUE);
//        }
//
//        private void update(int i, long val) {
//            tree[i] = val;
//            while (i < tree.length) {
//                tree[i] = Math.max(tree[i], val);
//                i += lowbit(i);
//            }
//        }
//
//        private long preMax(int i) {
//            long ans = Long.MIN_VALUE;
//            while (i > 0) {
//                ans = Math.max(ans, tree[i]);
//                i -= lowbit(i);
//            }
//            return ans;
//        }
//
//        private int lowbit(int x) {
//            return x & -x;
//        }
//    }
    class FenwickTree {
        private long[] tree; // max
        private long[] nums;

        public FenwickTree(int n) {
            tree = new long[n + 1];
            nums = new long[n + 1];
            Arrays.fill(tree, Long.MIN_VALUE);
            Arrays.fill(nums, Long.MIN_VALUE);
        }

        // 单点更新
        public void update(int i, long val) {
            nums[i] = val;
            while (i < tree.length) {
                tree[i] = nums[i];
                int lb = lowbit(i);
                for (int j = 1; j < lb; j <<= 1)
                    tree[i] = Math.max(tree[i], tree[i - j]);
                i += lowbit(i);
            }
        }

        // 区间查询
        public long query(int left, int right) {
            long ans = Integer.MIN_VALUE;
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

        // 为了这道题特意加的一个method
        public long preMax(int i) {
            return query(1, i);
        }


        private int lowbit(int i) {
            return i & -i;
        }
    }

    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++)
            b[i] = nums[i] - i;
        Arrays.sort(b);
        FenwickTree f = new FenwickTree(n);
        for (int i = 0; i < n; i++) {
            int j = Arrays.binarySearch(b, nums[i] - i) + 1;
            f.update(j, Math.max(f.preMax(j), 0) + nums[i]);
        }
        return f.preMax(n);
    }
}


// nums[i] - i >= nums[j] - j (i > j)