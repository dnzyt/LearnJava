package medium;

// 31. Next Permutation

import util.Bound;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        while (i - 1 >= 0 && nums[i - 1] >= nums[i])
            i -= 1;
        if (i == 0) {
            Arrays.sort(nums);
            return;
        }
        int[] c = Arrays.copyOfRange(nums, i, n);
        reverse(c);
        int idx = upperBound(c, nums[i - 1]);
        swap(nums, i - 1, n - 1 - idx);
        Arrays.sort(nums, i, n - 1);
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            swap(arr, l, r);
            l += 1;
            r -= 1;
        }
    }
}
