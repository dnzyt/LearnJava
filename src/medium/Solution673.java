package medium;

// 673. Number of Longest Increasing Subsequence

import java.util.ArrayList;
import java.util.List;

public class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[][] m = new int[n][2];
        m[0] = new int[]{1, 1,};
        for (int i = 0; i < n; i++) {
            dfs(i, nums, m);
        }
        int l = lis(nums);
        int count = 0;
        for (int[] row : m) {
            if (row[0] == l) count += row[1];
        }
        return count;
    }

    // 返回以i为结尾的最长上升子序列的长度和个数
    private int[] dfs(int i, int[] nums, int[][] m) {
        if (i == 0) return m[0];
        if (m[i][0] != 0) return m[i];
        int l = 0;
        int cnt = 0;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                int[] t = dfs(j, nums, m);
                if (l < t[0]) {
                    l = t[0];
                    cnt = t[1];
                } else if (l == t[0]) {
                    cnt += t[1];
                }
            } else if (nums[j] == nums[i]) {
                int[] t = dfs(j, nums, m);
                l = t[0] - 1;
                cnt = t[1];
            }
        }

        m[i] = new int[]{l + 1, l == 0 ? 1 : cnt};

        return m[i];
    }

    private int lis(int[] nums) {
        int n = nums.length;
        List<Integer> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int idx = lowerBound(g, nums[i]);
            if (idx == g.size()) g.add(nums[i]);
            else g.set(idx, nums[i]);
        }
        return g.size();
    }

    private int lowerBound(List<Integer> nums, int target) {
        int n = nums.size();
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums.get(mid) >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int findNumberOfLIS2(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        int[] cnt = new int[n];
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (len[j] < len[i]) {
                        len[i] = len[j];
                        cnt[i] = cnt[j];
                    }
                }
            }
            len[i] += 1;
            maxLen = Math.max(maxLen, len[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (len[i] == maxLen) ans += cnt[i];
        }
        return ans;
    }
}
