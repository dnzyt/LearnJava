package medium;

// 153. Find Minimum in Rotated Sorted Array

public class Solution153 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 2;
        int last = nums[nums.length - 1];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > last) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l];
    }
}
