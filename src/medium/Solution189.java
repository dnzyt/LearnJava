package medium;

// 189. Rotate Array

public class Solution189 {
    public void rotate(int[] nums, int k) {
        k = nums.length - k % nums.length;
        reverse(nums, 0, k);
        reverse(nums, k, nums.length);
        reverse(nums, 0, nums.length);
    }

    private void reverse(int[] nums, int l, int r) {
        int i = l, j = r - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return;
    }
}
