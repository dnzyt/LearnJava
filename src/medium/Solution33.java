package medium;

// 33. Search in Rotated Sorted Array

public class Solution33 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;

            if ((nums[mid] >= nums[0] && target >= nums[0]) || (nums[mid] < nums[0] && target < nums[0])) {
                // 有序的情况
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (target >= nums[0]) {
                // target在上
                right = mid - 1;
            } else {
                // target在下
                left = mid + 1;
            }
        }
        if (left == right && nums[left] == target)
            return left;
        return -1;
    }

}
