package easy;

// 575. Distribute Candies

import java.util.HashSet;
import java.util.Set;

public class Solution575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> s = new HashSet<>();
        for (int t : candyType)
            s.add(t);
        return Math.min(s.size(), candyType.length / 2);
    }
}
