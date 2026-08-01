package medium;

// 4001. Aggregate Two Time Series

import java.util.ArrayList;
import java.util.List;

public class Solution4001 {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int l1 = series1.length, l2 = series2.length;
        int i = 0, j = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while (i < l1 && j < l2) {
            int t1 = series1[i][0], v1 = series1[i][1];
            int t2 = series2[j][0], v2 = series2[j][1];
            if (t1 == t2) {
                ans.add(List.of(t1, v1 + v2));
                i++;
                j++;
            } else if (t1 < t2) {
                ans.add(List.of(t1, v1 +series2[j][1]));
                i++;
            } else {
                ans.add(List.of(t2, v2 + series1[i][1]));
                j++;
            }
        }
        while (i < l1) {
            int t1 = series1[i][0], v1 = series1[i][1];
            ans.add(List.of(t1, v1));
            i++;
        }
        while (j < l2) {
            int t2 = series2[j][0], v2 = series2[j][1];
            ans.add(List.of(t2, v2));
            j++;
        }
        return ans;
    }
}
