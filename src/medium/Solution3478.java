package medium;

// 3478. Choose K Elements With Maximum Sum

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3478 {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] p = new int[n][2]; // number, index
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long[] ans = new long[n];
        for (int i = 0; i < n; i++)
            p[i] = new int[]{nums1[i], i};
        Arrays.sort(p, Comparator.comparing(a -> a[0]));
        for (int i = 0; i < n; i++) {
            int num = p[i][0];
            int idx = p[i][1];
            if (p[i][0] == p[i - 1][0])
                ans[i] = ans[i - 1];
            else
                ans[i] = sum;
            pq.offer(nums2[idx]);
            sum += nums2[idx];
            if (pq.size() > k)
                sum -= pq.poll();
        }

        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[p[i][1]] = ans[i];
        }
        return res;
    }
}
