package medium;

// 3478. Choose K Elements With Maximum Sum

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution4378 {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        // i, nums1[i], nums2[i]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        List<int[]> s = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            s.add(new int[]{i, nums1[i], nums2[i]});
        }
        Collections.sort(s, (a, b) -> a[1] - b[1]);
        long[] ans = new long[nums1.length];
        long total = 0l;
        for (int i = 0; i < s.size(); i++) {
            int[] p = s.get(i);
            if (i == 0) {
                ans[p[0]] = 0;
                pq.offer(p);
                total += p[2];
            } else {
                int[] pre = s.get(i - 1);
                if (pre[1] == p[1])
                    ans[p[0]] = ans[pre[0]];
                else
                    ans[p[0]] = total;
                pq.offer(p);
                total += p[2];
                if (pq.size() > k)
                    total -= pq.poll()[2];
            }
        }
        return ans;
    }
}
