package easy;

// 3688. Bitwise OR of Even Numbers in an Array

public class Solution3688 {
    public int evenNumberBitwiseORs(int[] nums) {
        int res = 0;
        for (int num : nums)
            if (num % 2 == 0)
                res |= num;
        return res;
    }
}
