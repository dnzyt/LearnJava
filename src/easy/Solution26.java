package easy;

// 26. Remove Duplicates from Sorted Array

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[i]) continue;
            nums[++i] = nums[j];
        }
        return i + 1;
    }
}
