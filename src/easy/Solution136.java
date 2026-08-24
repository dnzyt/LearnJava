package easy;

// 136. Single Number

public class Solution136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums)
            ans ^= num;
        return ans;
    }
}
