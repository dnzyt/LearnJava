package hard;

// 3209. Number of Subarrays With AND Value of K

public class Solution3209 {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        for (int j = 0; j < n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if ((nums[i] & nums[j]) == nums[i]) break;
                nums[i] &= nums[j];
            }
            ans += lowerBound(nums, k + 1, 0, j + 1) - lowerBound(nums, k, 0, j + 1);
        }
        return ans;
    }

    private int lowerBound(int[] nums, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    // 三指针
    public long countSubarrays2(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[j] & nums[i]) == nums[j])
                    break;
                nums[j] &= nums[i];
            }
            while (left <= i && nums[left] < k)
                left++;
            while (right <= i && nums[right] <= k)
                right++;
            ans += right - left;
        }
        return ans;
    }
}
