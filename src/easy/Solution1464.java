package easy;

// 1464. Maximum Product of Two Elements in an Array

public class Solution1464 {
    public int maxProduct(int[] nums) {
        int a = -1, b = -1;
        for (int num : nums) {
            if (num > a) {
                b = a;
                a = num;
            } else if (num > b)
                b = num;
        }
        return (a - 1) * (b - 1);
    }
}
