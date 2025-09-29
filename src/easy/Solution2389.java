package easy;

// 2389. Longest Subsequence With Limited Sum

import java.util.Arrays;

public class Solution2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] s = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            s[i + 1] = s[i] + nums[i];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = findPosition(s, queries[i]);
        }
        return ans;
    }

    private int findPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right;
    }
}
