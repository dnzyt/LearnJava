package easy;

// 1752. Check if Array Is Sorted and Rotated

public class Solution1752 {
    public boolean check(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (cnt > 0 && nums[i] > nums[0])
                return false;
            if (nums[i - 1] > nums[i]) {
                cnt++;
                if (nums[i] > nums[0] || cnt > 1)
                    return false;
            }
        }
        return true;
    }
}
