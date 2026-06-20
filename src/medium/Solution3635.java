package medium;

// 3635. Earliest Finish Time for Land and Water Rides II

import java.util.*;

public class Solution3635 {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int a = check(landStartTime, landDuration, waterStartTime, waterDuration);
        int b = check(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(a, b);
    }

    private int check(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minFinish = Integer.MAX_VALUE / 2;
        for (int i = 0; i < landStartTime.length; i++)
            minFinish = Math.min(minFinish, landStartTime[i] + landDuration[i]);
        int minDuration = Integer.MAX_VALUE / 2;
        int ans = Integer.MAX_VALUE / 2;
        for (int i = 0; i < waterStartTime.length; i++) {
            if (waterStartTime[i] < minFinish)
                minDuration = Math.min(minDuration, waterDuration[i]);
            else {
                ans = Math.min(ans, waterStartTime[i] + waterDuration[i]);
            }
        }
        return Math.min(ans, minFinish + minDuration);
    }
}
