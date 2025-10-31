package medium;

// 1942. The Number of the Smallest Unoccupied Chair

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1942 {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetStart = times[targetFriend][0];
        Arrays.sort(times, Comparator.comparing(a -> a[0]));
        int seat = 0;
        PriorityQueue<Integer> back = new PriorityQueue<>();
        PriorityQueue<int[]> leave = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int[] t : times) {
            while (!leave.isEmpty() && leave.peek()[0] <= t[0]) {
                back.offer(leave.poll()[1]);
            }
            int currSeat = seat;
            if (!back.isEmpty())
                currSeat = back.poll();
            else
                seat++;
            if (t[0] == targetStart)
                return currSeat;
            leave.offer(new int[]{t[1], currSeat});
        }
        return -1;
    }
}
