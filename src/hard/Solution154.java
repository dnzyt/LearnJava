package hard;

// 154. Find Minimum in Rotated Sorted Array II

public class Solution154 {
    public int findMin(int[] nums) {
        // 红蓝染色法
        // 蓝色：把最小值或者大于最小值的数染成蓝色
        // 红色：把小于最小值的数染成红色
        // 最后一个数一定是蓝色
        // mid每次都和最后一个数比较，就能确定mid和其中一侧的颜色
        int n = nums.length;
        int l = 0, r = n - 2;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] < nums[r + 1])
                r = mid - 1;
            else if (nums[l] > nums[r + 1])
                l = mid + 1;
            else
                r--; // 如果相等的话，最后一个数就不要了，不会影响答案,如果是最小值，那么还有nums[mid]，如果不是最小值，那更应该舍弃
        }
        return nums[l];
    }
}
