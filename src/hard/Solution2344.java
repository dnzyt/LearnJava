package hard;

// 2344. Minimum Deletions to Make Array Divisible

import java.util.Arrays;

public class Solution2344 {
    public int minOperations(int[] nums, int[] numsDivide) {
        int g = 0;
        for (int num : numsDivide)
            g = gcd(g, num);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
            if (g % nums[i] == 0)
                return i;
        return -1;
    }

    private int gcd(int x, int y) {
        while (x != 0) {
            int tmp = x;
            x = y % x;
            y = tmp;
        }
        return y;
    }
}
