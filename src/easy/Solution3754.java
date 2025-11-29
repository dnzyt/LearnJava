package easy;

// 3754. Concatenate Non-Zero Digits and Multiply by Sum I

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution3754 {
    public long sumAndMultiply(int n) {
        List<Integer> digits = new ArrayList<>();
        long sum = 0;
        while (n != 0) {
            int d = n % 10;
            n /= 10;
            sum += d;
            if (d > 0)
                digits.add(d);
        }
        long x = 0;
        long times = 1;
        for (int d : digits) {
            x += d * times;
            times *= 10;
        }
        return sum * x;
    }
}
