package easy;

// 3718. Smallest Missing Multiple of K

import java.util.HashSet;
import java.util.Set;

public class Solution3718 {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums)
            s.add(num);
        int i = 1;
        while (true) {
            if (!s.contains(k * i))
                return k * i;
            i++;
        }
    }
}
