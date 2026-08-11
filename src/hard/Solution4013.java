package hard;

// 4013. Count Subarrays With Even Odd Ratio II

import java.util.Arrays;
import java.util.Set;

public class Solution4013 {

    class FenwickTree {
        private int[] sum;

        public FenwickTree(int n) {
            sum = new int[n + 1];
        }

        public void add(int i, int val) {
            while (i < sum.length) {
                sum[i] += val;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int res = 0;
            while (i > 0) {
                res += sum[i];
                i -= lowbit(i);
            }
            return res;
        }

        private int lowbit(int i) {
            return i & -i;
        }
    }


    public long countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        long[] presum = new long[n + 1];
        for (int i = 0; i < n; i++)
            presum[i + 1] = presum[i] + ((nums[i] % 2 == 0) ? -b : a);
        return mergeCount(presum);
    }


    // 归并排序
    private long mergeCount(long[] nums) {
        int n = nums.length;
        if (n <= 1)
            return 0;
        long[] a = Arrays.copyOfRange(nums, 0, n / 2);
        long[] b = Arrays.copyOfRange(nums, n / 2, n);
        long res = mergeCount(a) + mergeCount(b);
        int l = 0, r = 0;
        // 双指针
        for (int i = 0; i < n; i++) {
            if (l < a.length && (r == b.length || a[l] <= b[r])) {
                nums[i] = a[l];
                l++;
            } else {
                nums[i] = b[r];
                res += l;
                r++;
            }
        }
        return res;
    }

    public long countRatioSubarrays2(int[] nums, int a, int b) {
        int n = nums.length;
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++)
            s[i + 1] = s[i] + ((nums[i] % 2 == 0) ? -b : a);
        long[] sortedS = s.clone();
        Arrays.sort(sortedS);

        FenwickTree f = new FenwickTree(n + 1);
        long ans = 0;
        for (long x : s) {
            int idx = Arrays.binarySearch(sortedS, x) + 1;
            ans += f.query(idx);
            f.add(idx, 1);
        }
        return ans;
    }
}
