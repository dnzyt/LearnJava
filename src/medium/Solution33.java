package medium;

// 33. Search in Rotated Sorted Array

public class Solution33 {
    // 红蓝染色法 （二分）
    // nums[mid]在target左侧则标记为红色
    // nums[mid]为target或在target右侧则标记为蓝色
    public int search(int[] nums, int target) {
        // 分三种情况讨论
        // 1. target在左边上升段，nums[mid]在右边上升段
        // 2. nums[mid]在左边上升段，target在右边上升段
        // 3. target和nums[mid]在同一段

        int l = 0;
        int r = nums.length - 2;
        int last = nums[nums.length - 1];
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (target > last && nums[mid] <= last) {
                r = mid - 1;
            } else if (nums[mid] > last && target <= last) {
                l = mid + 1;
            } else if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;

    }

}
