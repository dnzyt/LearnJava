package easy;

// 888. Fair Candy Swap

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution888 {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aSum = Arrays.stream(aliceSizes).sum();
        int bSum = Arrays.stream(bobSizes).sum();

        // x = y + (sumA - sumB) / 2
        int target = (aSum - bSum) / 2;
        Set<Integer> s = new HashSet<>();
        for (int x : aliceSizes)
            s.add(x);
        for (int y : bobSizes)
            if (s.contains(y + target))
                return new int[]{y + target, y};
        return null;
    }
}
