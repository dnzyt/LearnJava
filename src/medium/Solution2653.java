package medium;

// 2653. Sliding Subarray Beauty

import java.util.*;

public class Solution2653 {
    // 计数排序+滑动窗口
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] buckets = new int[101];
        for (int i = 0; i < k - 1; i++)
            buckets[nums[i] + 50]++;

        int[] ans = new int[n - k + 1];
        for (int i = k - 1; i < n; i++) {
            int inVal = nums[i];
            buckets[inVal + 50]++;
            int left = x;
            for (int j = -50; j < 0; j++) {
                left -= buckets[j + 50];
                if (left <= 0) {
                    ans[i - k + 1] = j;
                    break;
                }
            }
            int outVal = nums[i - k + 1];
            buckets[outVal + 50]--;
        }
        return ans;
    }

    class FenwickTree {
        private int[] tree;

        public FenwickTree(int n) {
            tree = new int[n + 1];
        }

        public void update(int i, int delta) {
            while (i < tree.length) {
                tree[i] += delta;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int ans = 0;
            while (i > 0) {
                ans += tree[i];
                i -= lowbit(i);
            }
            return ans;
        }

        private int lowbit(int i) {
            return i & -i;
        }
    }

    // 通用解法
    public int[] getSubarrayBeauty2(int[] nums, int k, int x) {
        SortedSet<Integer> ss = new TreeSet<>();
        for (int num : nums)
            ss.add(num);
        List<Integer> s = new ArrayList<>(ss);
        FenwickTree f = new FenwickTree(s.size() + 1);
        List<Integer> ans = new ArrayList<>();

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            int idx = Collections.binarySearch(s, nums[i]);
            f.update(idx + 1, 1);
            if (i - j + 1 > k) {
                idx = Collections.binarySearch(s, nums[j]);
                f.update(idx + 1, -1);
                j++;
            }
            if (i - j + 1 == k) {
                idx = lowerBound(f, 1, s.size(), x) - 1;
                ans.add(Math.min(s.get(idx), 0));
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private int lowerBound(FenwickTree f, int l, int r, int x) {
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int cnt = f.query(mid);
            if (cnt < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
