package medium;

// 2279. Maximum Bags With Full Capacity of Rocks

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2279 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < capacity.length; i++)
            s.add(capacity[i] - rocks[i]);
        Collections.sort(s);
        int ans = 0;
        for (int c : s) {
            additionalRocks -= c;
            if (additionalRocks >= 0)
                ans++;
            else
                break;
        }
        return ans;
    }

}
