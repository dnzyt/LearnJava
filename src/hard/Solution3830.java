package hard;

// 3830. Longest Alternating Subarray After Removing At Most One Element

public class Solution3830 {
    public int longestAlternating(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] == nums[i])
                pre[i] = 1;
            else if (i - 2 < 0)
                pre[i] = 2;
            else {
                if (Integer.compare(nums[i - 2], nums[i - 1]) == Integer.compare(nums[i - 1], nums[i]))
                    pre[i] = 2;
                else
                    pre[i] = pre[i - 1] + 1;
            }
        }

        int[] suffix = new int[n];
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] == nums[i + 1])
                suffix[i] = 1;
            else if (i + 2 == n)
                suffix[i] = 2;
            else {
                if (Integer.compare(nums[i], nums[i + 1]) == Integer.compare(nums[i + 1], nums[i + 2]))
                    suffix[i] = 2;
                else
                    suffix[i] = suffix[i + 1] + 1;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(Math.max(pre[i], suffix[i]), res);
        }


        for (int i = 1; i < n - 2; i++) {
            if (nums[i - 1] == nums[i + 1])
                continue;
            int trend = Integer.compare(nums[i - 1], nums[i + 1]);
            // i - 2 < 0  1
            // Integer.compare(nums[i - 2], nums[i - 1]) == trend     1
            //                                                        pre[i - 1]
            int left = (i - 2 < 0 || Integer.compare(nums[i - 2], nums[i - 1]) == trend) ? 1 : pre[i - 1];

            // i + 2 >= n   1
            // Integer.compare(nums[i + 1], nums[i + 2]) == trend     1
            //                                                        suffix[i + 1]
            int right = (i + 2 >= n || Integer.compare(nums[i + 1], nums[i + 2]) == trend) ? 1 : suffix[i + 1];
            res = Math.max(res, left + right);
        }

        return res;
    }
}
