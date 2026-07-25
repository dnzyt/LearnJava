package medium;

// 1291. Sequential Digits

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for (int d = 1; d < 10; d++) {
            int x = d;
            for (int k = d + 1; k < 10; k++) {
                x = x * 10 + k;
                if (x > high)
                    break;
                if (x >= low)
                    ans.add(x);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
