package medium;

// 4054. Count Shadow Pairs I

import java.util.ArrayList;
import java.util.List;

public class Solution4054 {
    public long shadowPairs(int[] nums) {
        int n = nums.length;
        List<int[]> st = new ArrayList<>();
        st.add(new int[]{0, 0});
        long total = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            while (st.get(st.size() - 1)[0] > nums[i]) {
                int[] last = st.remove(st.size() - 1);
                total -= last[1];
            }
            ans += total;

            int[] last = st.get(st.size() - 1);
            if (last[0] == nums[i]) {
                ans -= last[1];
                last[1]++;
            } else {
                st.add(new int[]{nums[i], 1});
            }

            total++;
        }
        return ans;
    }
}
