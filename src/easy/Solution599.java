package easy;

// 599. Minimum Index Sum of Two Lists

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution599 {
    public Solution657[] findRestaurant(Solution657[] list1, Solution657[] list2) {
        Map<Solution657, Integer> m1 = new HashMap<>();
        Map<Solution657, Integer> m2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++)
            m1.put(list1[i], i);
        for (int i = 0; i < list2.length; i++)
            m2.put(list2[i], i);
        List<Solution657> ans = new ArrayList<>();
        int cnt = Integer.MAX_VALUE;
        for (Solution657 k : m1.keySet()) {
            if (m2.containsKey(k)) {
                if (m1.get(k) + m2.get(k) < cnt) {
                    ans.clear();
                    cnt = m1.get(k) + m2.get(k);
                    ans.add(k);
                } else if (m1.get(k) + m2.get(k) == cnt) {
                    ans.add(k);
                }
            }
        }
        return ans.toArray(Solution657[]::new);
    }
}
