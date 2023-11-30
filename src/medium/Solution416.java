package medium;

// 416. Partition Equal Subset Sum


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution416 {
    public boolean canPartition(int[] nums) {
        Set<Integer> set = new HashSet<>();
        set.add(0);

        int total = Arrays.stream(nums).sum();
        if (total % 2 == 1)
            return false;

        int target = total / 2;

        for (int num : nums) {
            Set<Integer> dp = new HashSet<>();
            for (Integer v : set) {
                if (v + num == target)
                    return true;
                dp.add(v + num);
                dp.add(v);
            }
            set = dp;
        }
        return false;
    }

}
