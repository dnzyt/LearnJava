package medium;

// 2568. Minimum Impossible OR

import java.util.HashSet;
import java.util.Set;

public class Solution2568 {
    // 看2的幂是否包含在数组中，任何数都是由2的幂次组成的
    public int minImpossibleOR(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums)
            s.add(num);
        int k = 1;
        for (int i = 0; i < 32; i++) {
            if (!s.contains(1 << k))
                return k;
            k *= 2;
        }
        return 0;
    }

    public int minImpossibleOR2(int[] nums) {
        int mask = 0;
        for (int num : nums) {
            if ((num & (num - 1)) == 0)
                mask |= num;
        }
        mask = ~mask;
        return mask & -mask;
    }
}
