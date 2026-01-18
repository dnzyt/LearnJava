package hard;

// 2426. Number of Pairs Satisfying Inequality

import java.util.Arrays;

public class Solution2426 {

    class FenwickTree {
        long[] tree;

        public FenwickTree(int n) {
            tree = new long[n + 1];
        }

        public void add(int i, int val) {
            while (i < tree.length) {
                tree[i] += val;
                i += lowbit(i);
            }
        }

        public long query(int i) {
            long res = 0L;
            while (i > 0) {
                res += tree[i];
                i -= lowbit(i);
            }
            return res;
        }

        private int lowbit(int x) {
            return x & -x;
        }
    }


    // FenwickTree + 离散化
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = nums1[i] - nums2[i];

        int[] b = nums.clone();
        Arrays.sort(b);

        long res = 0;
        FenwickTree f = new FenwickTree(n);
        for (int i = 0; i < n; i++) {
            int idx = upperBound(b, nums[i] + diff);
            res += f.query(idx);
            f.add(lowerBound(b, nums[i]) + 1, 1);
        }
        return res;
    }

    private int lowerBound(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target)
                right = mid;
            else
                left = mid;
        }
        return right;
    }


    private int upperBound(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] <= target)
                left = mid;
            else
                right = mid;
        }
        return right;
    }
}
