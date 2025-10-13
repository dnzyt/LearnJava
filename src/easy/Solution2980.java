package easy;

// 2980. Check if Bitwise OR Has Trailing Zeros

public class Solution2980 {
    public boolean hasTrailingZeros(int[] nums) {
        int count = 0;
        for (int num : nums)
            count += (num & 1);
        return nums.length - count >= 2;
    }
}
