package medium;

// 3804. Number of Centered Subarrays

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3804 {
    public int centeredSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> st = new HashSet<>();
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                st.add(nums[j]);
                if (st.contains(sum))
                    ans++;
            }
        }
        return ans;
    }
}
