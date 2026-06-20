package easy;

// 3158. Find the XOR of Numbers Which Appear Twice

import java.util.HashSet;
import java.util.Set;

public class Solution3158 {
    public int duplicateNumbersXOR(int[] nums) {
        int ans = 0;
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            if (s.contains(num))
                ans ^= num;
            s.add(num);
        }
        return ans;
    }
}
