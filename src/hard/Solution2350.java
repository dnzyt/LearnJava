package hard;

// 2350. Shortest Impossible Sequence of Rolls

import java.util.HashSet;
import java.util.Set;

public class Solution2350 {
    // 构造题
    public int shortestSequence(int[] rolls, int k) {
        Set<Integer> s = new HashSet<>();
        int ans = 1;
        for (int num : rolls) {
            s.add(num);
            if (s.size() == k) {
                ans++;
                s.clear();
            }
        }
        return ans;
    }
}
