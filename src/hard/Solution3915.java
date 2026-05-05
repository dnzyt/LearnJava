package hard;

// 3915. Maximum Sum of Alternating Subsequence With Distance at Least K

import java.util.*;

public class Solution3915 {

    class FenwickTree {

        private long[] tree;

        public FenwickTree(int n) {
            tree = new long[n + 1];
        }

        public void update(int i, long val) {
            while (i < tree.length) {
                tree[i] = Math.max(tree[i], val);
                i += lowbit(i);
            }
        }

        public long query(int i) {
            long ans = 0;
            while (i > 0) {
                ans = Math.max(tree[i], ans);
                i -= lowbit(i);
            }
            return ans;
        }

        private int lowbit(int i) {
            return i & -i;
        }
    }

    // 状态机DP + 树状数组维护前缀最大值
    public long maxAlternatingSum(int[] nums, int k) {
        int n = nums.length;
        long[] fInc = new long[n];
        long[] fDec = new long[n];
        SortedSet<Integer> ss = new TreeSet<>();
        for (int num : nums)
            ss.add(num);
        List<Integer> sorted = new ArrayList<>();
        for (int num : ss) {
            sorted.add(num);
        }
        int m = sorted.size();
        FenwickTree fenwickInc = new FenwickTree(m);
        FenwickTree fenwickDec = new FenwickTree(m);

        long mxInc = 0, mxDec = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (i - k >= 0) {
                int idx = nums[i - k];
                fenwickInc.update(m - idx, fInc[i - k]);
                fenwickDec.update(idx + 1, fDec[i - k]);
            }
            int idx = Collections.binarySearch(sorted, nums[i]);
            nums[i] = idx; // 直接更新为离散化后的值，后面也不会用到nums[i]，更新FenwickTree的时候就不用求一遍离散化的值了
            fInc[i] = fenwickDec.query(idx) + x;
            fDec[i] = fenwickInc.query(m - (idx + 1)) + x;
            mxInc = Math.max(mxInc, fInc[i]);
            mxDec = Math.max(mxDec, fDec[i]);
        }
        return Math.max(mxInc, mxDec);
    }
}
