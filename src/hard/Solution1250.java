package hard;

// 1250. Check If It Is a Good Array

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1250 {
    public boolean isGoodArray(int[] nums) {
        int ans = 0;
        for (int num : nums)
            ans = gcd(num, ans);
        return ans == 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
