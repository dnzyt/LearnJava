package medium;

// 636. Exclusive Time of Functions

import java.util.ArrayList;
import java.util.List;

public class Solution636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];

        // { id, timestamp, intervals }
        List<int[]> st = new ArrayList<>();


        for (String log : logs) {
            String[] v = log.split(":");
            int time = Integer.parseInt(v[2]), op = v[1].equals("start") ? 0 : 1, id = Integer.parseInt(v[0]);

            if (op == 0) {
                st.add(new int[]{id, time, 0});
            } else {
                int[] x = st.get(st.size() - 1);
                st.remove(st.size() - 1);
                int startTime = x[1], intervals = x[2];
                ans[id] += time - startTime + 1 - intervals;

                if (!st.isEmpty()) {
                    int[] pre = st.get(st.size() - 1);
                    pre[2] += time - startTime + 1;
                }
            }
        }

        return ans;
    }
}
