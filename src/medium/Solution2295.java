package medium;

// 2295. Replace Elements in an Array

import java.util.HashMap;
import java.util.Map;

public class Solution2295 {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> numToIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            numToIdx.put(nums[i], i);
        for (int[] op : operations) {
            int num = op[0], val = op[1];
            int idx = numToIdx.get(num);
            nums[idx] = val;
            numToIdx.put(val, idx);
        }
        return nums;
    }
}
