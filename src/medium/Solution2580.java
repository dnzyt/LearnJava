package medium;

// 2580. Count Ways to Group Overlapping Ranges

import java.util.Arrays;
import java.util.Comparator;

public class Solution2580 {

    public int countWays(int[][] ranges) {
        int n = ranges.length;
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        int farthest = ranges[0][1];
        for (int i = 1; i < ranges.length; i++) {
            if (ranges[i][0] <= farthest)
                n --;
            if (farthest < ranges[i][1])
                farthest = ranges[i][1];
        }
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = res * 2 % 1000000007;
        }
        return res;
    }

}
