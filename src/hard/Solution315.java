package hard;

// 315. Count of Smaller Numbers After Self

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution315 {

    class FenwickTree {
        int[] tree;

        public FenwickTree(int n) {
            tree = new int[n + 1];
        }

        public void add(int i, int v) {
            while (i < tree.length) {
                tree[i] += v;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int res = 0;
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


    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] b = nums.clone();
        Arrays.sort(b);

        List<Integer> ans = new ArrayList<>();
        FenwickTree f = new FenwickTree(n);

        for (int i = n - 1; i >= 0; i--) {
            int idx = upperBound(b, nums[i] - 1);
            ans.add(f.query(idx));
            f.add(idx + 1, 1);
        }

        Collections.reverse(ans);
        return ans;
    }

    private int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
