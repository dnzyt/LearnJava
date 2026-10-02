package medium;

// 4066. Maximum Equal Adjacent Pairs After at Most One Replacement

import java.util.HashMap;
import java.util.Map;

public class Solution4066 {
    public int maxEqualAdjacentPairs(int[] nums) {
        int mx = 0;
        Map<Long, Integer> cnt = new HashMap<>();
        int base = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i])
                base++;
            else {
                long a = nums[i - 1], b = nums[i];
                if (a > b) {
                    long tmp = a;
                    a = b;
                    b = tmp;
                }
                cnt.merge(a << 32 | b, 1, Integer::sum);
                mx = Math.max(mx, cnt.get(a << 32 | b));
            }
        }


        return mx + base;
    }
}
