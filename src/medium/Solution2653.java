package medium;

// 2653. Sliding Subarray Beauty

import java.util.ArrayList;
import java.util.List;

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
}
