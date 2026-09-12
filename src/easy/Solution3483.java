package easy;

// 3483. Unique 3-Digit Even Numbers

import java.util.HashSet;
import java.util.Set;

public class Solution3483 {
    public int totalNumbers(int[] digits) {
        Set<Integer> ans = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            if (digits[i] % 2 != 0)
                continue;
            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;
                for (int k = 0; k < n; k++) {
                    if (digits[k] == 0 || k == i || k == j)
                        continue;
                    ans.add(digits[k] * 100 + digits[j] * 10 + digits[i]);
                }
            }
        }
        return ans.size();
    }
}
