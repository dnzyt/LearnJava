package medium;

// 2161. Partition Array According to Given Pivot

import java.util.ArrayList;
import java.util.List;

public class Solution2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        for (int num : nums) {
            if (num < pivot)
                left.add(num);
            else if (num > pivot)
                right.add(num);
            else
                mid.add(num);
        }
        left.addAll(mid);
        left.addAll(right);
        return left.stream().mapToInt(Integer::intValue).toArray();
    }
}
