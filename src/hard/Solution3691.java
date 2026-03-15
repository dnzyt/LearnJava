package hard;

// 3691. Maximum Total Subarray Value II

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3691 {
    private int[][] stmax;
    private int[][] stmin;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int p = 32 - Integer.numberOfLeadingZeros(n);

        stmax = new int[n][p];
        stmin = new int[n][p];
        for (int i = 0; i < n; i++) {
            stmax[i][0] = nums[i];
            stmin[i][0] = nums[i];
        }
        for (int j = 1; j < p; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                stmax[i][j] = Math.max(stmax[i][j - 1], stmax[i + (1 << (j - 1))][j - 1]);
                stmin[i][j] = Math.min(stmin[i][j - 1], stmin[i + (1 << (j - 1))][j - 1]);
            }
        }

        long ans = 0l;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[0]));

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{queryMaxMin(i, n - 1), i, n - 1});
        }

        int cnt = 0;
        while (cnt < k) {
            cnt++;
            int[] curr = pq.poll();
            ans += curr[0];
            curr[2]--;
            if (curr[1] > curr[2])
                continue;
            curr[0] = queryMaxMin(curr[1], curr[2]);
            pq.offer(curr);

        }
        return ans;
    }

    private int queryMaxMin(int left, int right) {
        int n = right - left + 1;
        int p = 32 - Integer.numberOfLeadingZeros(n);
        // System.out.println("l: " + left + " right: " + right + " p: " + p);
        int a = Math.max(stmax[left][p - 1], stmax[right - (1 << (p - 1)) + 1][p - 1]);
        int b = Math.min(stmin[left][p - 1], stmin[right - (1 << (p - 1)) + 1][p - 1]);
        return a - b;
    }
}


/*
 * val, left, right
 *
 *
 * */