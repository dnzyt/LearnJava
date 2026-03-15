package medium;

// 2831. Find the Longest Equal Subarray

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2831 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if (!map.containsKey(num))
                map.put(num, new ArrayList<>());
            map.get(num).add(i);
        }
        int ans = 0;
        for (int num : map.keySet()) {
            List<Integer> positions = map.get(num);
            int i = 0;
            for (int j = 0; j < positions.size(); j++) {
                int left = positions.get(i);
                int right = positions.get(j);
                while (right - left + 1 - (j - i + 1) > k) {
                    i++;
                    left = positions.get(i);
                }
                ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}
