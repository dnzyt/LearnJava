package easy;

// 2553. Separate the Digits in an Array

import java.util.ArrayList;
import java.util.List;

public class Solution2553 {
    public int[] separateDigits(int[] nums) {
        List<Integer> s = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            while (num > 0) {
                s.add(num % 10);
                num /= 10;
            }
        }
        return s.reversed().stream().mapToInt(Integer::intValue).toArray();
    }
}
