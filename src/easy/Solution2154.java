package easy;

// 2154. Keep Multiplying Found Values by Two

public class Solution2154 {
    public int findFinalValue(int[] nums, int original) {
        int mask = 0;
        for (int num : nums) {
            if (num % original == 0) {
                int k = num / original;
                if ((k & (k - 1)) == 0) {
                    mask |= k;
                }
            }
        }
        mask = ~mask;
        return original * (mask & -mask);
    }
}
