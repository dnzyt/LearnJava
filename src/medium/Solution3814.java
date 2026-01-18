package medium;

// 3814. Maximum Capacity Within Budget

import java.util.*;

public class Solution3814 {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        List<int[]> cc = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (costs[i] >= budget)
                continue;
            cc.add(new int[]{costs[i], capacity[i]});
        }
        Collections.sort(cc, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        int res = 0;

        List<int[]> st = new ArrayList<>();
        for (int i = 0; i < cc.size(); i++) {
            int[] curr = cc.get(i);
            if (curr[0] < budget)
                res = Math.max(res, curr[1]);

            while (!st.isEmpty() && st.getLast()[0] + curr[0] >= budget)
                st.removeLast();

            if (!st.isEmpty())
                res = Math.max(res, curr[1] + st.getLast()[1]);

            if (st.isEmpty() || curr[1] > st.getLast()[1])
                st.add(curr);

        }
        return res;
    }
}
