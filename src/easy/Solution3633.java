package easy;

// 3633. Earliest Finish Time for Land and Water Rides I

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution3633 {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        List<int[]> l1 = new ArrayList<>();
        List<int[]> l2 = new ArrayList<>();
        int mn1 = Integer.MAX_VALUE;
        int mn2 = Integer.MAX_VALUE;
        for (int i = 0; i < landDuration.length; i++) {
            l1.add(new int[]{landStartTime[i], landStartTime[i] + landDuration[i]});
            mn1 = Math.min(mn1, landDuration[i]);
        }
        for (int i = 0; i < waterStartTime.length; i++) {
            l2.add(new int[]{waterStartTime[i], waterStartTime[i] + waterDuration[i]});
            mn2 = Math.min(mn2, waterDuration[i]);
        }
        int ans1 = check(l1, l2);
        int ans2 = check(l2, l1);

        return Math.min(ans1, ans2);
    }

    private int check(List<int[]> l1, List<int[]> l2) {
        Collections.sort(l1, Comparator.comparingInt(a -> a[1]));
        Collections.sort(l2, Comparator.comparingInt(a -> a[0]));
        int target = l1.getFirst()[1];
        List<int[]> l3 = new ArrayList<>();
        for (int[] a : l2) {
            if (l3.isEmpty())
                l3.add(a);
            else {
                int end = l3.getLast()[1];
                while (a[1] <= end) {
                    l3.removeLast();
                    if (l3.isEmpty())
                        break;
                    end = l3.getLast()[1];
                }
                l3.add(a);
            }
        }
        List<Integer> left = new ArrayList<>();
        int mn = Integer.MAX_VALUE;
        for (int i = 0; i < l3.size(); i++) {
            mn = Math.min(mn, l3.get(i)[1] - l3.get(i)[0]);
            left.add(mn);
        }
        int idx = lowerBound(l3, target);
        if (idx == 0)
            return l3.getFirst()[1];
        if (idx == l3.size())
            return l1.getFirst()[1] + mn;
        return Math.min(l1.getFirst()[1] + left.get(idx - 1), l3.get(idx)[1]);
    }

    private int lowerBound(List<int[]> nums, int target) {
        int n = nums.size();
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums.get(mid)[0] >= target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}
