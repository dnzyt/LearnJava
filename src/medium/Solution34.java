package medium;

// 34. Find First and Last Position of Element in Sorted Array

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int l = lowerBound(nums, target);
        if (l == nums.length || nums[l] != target) return new int[] {-1, -1};
        int r = lowerBound(nums, target + 1) - 1;
        return new int[] {l, r};
    }

    private int lowerBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}
