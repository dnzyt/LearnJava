package medium;

// 3811. Number of Alternating XOR Partitions

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3811 {
    private static final int MOD = 1000000007;

    public int alternatingXOR(int[] nums, int target1, int target2) {
        Map<Integer, Integer> f1 = new HashMap<>();
        Map<Integer, Integer> f2 = new HashMap<>();

        f2.put(0, 1);
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            xor ^= x;
            int last1 = f2.getOrDefault(xor ^ target1, 0);
            int last2 = f1.getOrDefault(xor ^ target2, 0);
            if (i == nums.length - 1)
                return (last1 + last2) % MOD;
            f1.put(xor, (f1.getOrDefault(xor, 0) + last1) % MOD);
            f2.put(xor, (f2.getOrDefault(xor, 0) + last2) % MOD);
        }
        return 0;
    }

}
