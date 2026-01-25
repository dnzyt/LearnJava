package easy;

// 3507. Minimum Pair Removal to Sort Array I

import java.util.ArrayList;
import java.util.List;

public class Solution3507 {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums)
            list.add(num);
        int res = 0;
        while (list.size() > 1) {
            boolean ascending = true;
            int sum = Integer.MAX_VALUE;
            int targetIdx = -1;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) + list.get(i + 1) < sum) {
                    sum = list.get(i) + list.get(i + 1);
                    targetIdx = i;
                }
                if (list.get(i) > list.get(i + 1))
                    ascending = false;
            }
            if (ascending)
                break;
            res++;
            list.set(targetIdx, sum);
            list.remove(targetIdx + 1);
        }
        return res;
    }
}
