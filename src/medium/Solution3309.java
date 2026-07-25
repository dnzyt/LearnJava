package medium;

// 3309. Maximum Possible Number by Binary Concatenation

import java.util.Arrays;

public class Solution3309 {
    public int maxGoodNumber(int[] nums) {
        nums = Arrays.stream(nums).boxed().sorted((a, b) -> {
            int lenA = 32 - Integer.numberOfLeadingZeros(a);
            int lenB = 32 - Integer.numberOfLeadingZeros(b);
            return (b << lenA | a) - (a << lenB | b);
        }).mapToInt(Integer::intValue).toArray();
        int ans = 0;
        for (int num : nums) {
            int l = 32 - Integer.numberOfLeadingZeros(num);
            ans = ans << l | num;
        }
        return ans;
    }
}
