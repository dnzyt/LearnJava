package hard;

// 2935. Maximum Strong Pair XOR II

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2935 {
    public int maximumStrongPairXor(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Map<Integer, Integer> mapping = new HashMap<>();
        int ans = 0;
        int highBits = 0;
        int width = 32 - Integer.numberOfLeadingZeros(nums[n - 1]);

        for (int i = width - 1; i >= 0; i--) {
            int target = ans | (1 << i);
            highBits |= (1 << i);
            mapping.clear();
            for (int j = 0; j < n; j++) {
                int x = nums[j] & highBits;
                int want = (target & highBits) ^ x;
                if (mapping.containsKey(want) && mapping.get(want) * 2 >= nums[i]) {
                    ans = target;
                    break;
                }
                mapping.put(x, nums[j]);
            }
        }
        return ans;
    }
}
