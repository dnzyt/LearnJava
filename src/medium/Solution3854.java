package medium;

// 3854. Minimum Operations to Make Array Parity Alternating

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution3854 {
    public int[] makeParityAlternating(int[] nums) {
        int[] ans1 = calc(0, nums);
        int[] ans2 = calc(1, nums);
        if (ans1[0] < ans2[0] || ans1[0] == ans2[0] && ans1[1] < ans2[1])
            return ans1;
        return ans2;
    }

    private int[] calc(int head, int[] nums) {
        int n = nums.length;
        int cnt = 0;
        List<List<Integer>> groups = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((head ^ (i % 2)) == (nums[i] & 1)) {
                groups.add(List.of(nums[i]));
            } else {
                cnt++;
                groups.add(List.of(nums[i] - 1, nums[i] + 1));
            }
        }
        int ans = smallestRange(groups);
        return new int[]{cnt, ans};
    }

    private int smallestRange(List<List<Integer>> groups) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < groups.size(); i++) {
            List<Integer> g = groups.get(i);
            int[] x = new int[]{g.get(i), 0, i};
            r = Math.max(r, x[0]);
            pq.offer(x);
        }
        int l = pq.peek()[0];
        int ans = r - l;
        while (pq.peek()[1] + 1 < groups.get(pq.peek()[2]).size()) {
            int[] top = pq.poll();
            top[0] = groups.get(top[2]).get(++top[1]);
            r = Math.max(r, top[0]);
            pq.offer(top);
            l = pq.peek()[0];
            ans = Math.min(ans, r - l);
        }
        return ans;
    }
}
