package medium;

// 1845. Seat Reservation Manager

import java.util.PriorityQueue;

public class Solution1845 {
    class SeatManager {
        private PriorityQueue<Integer> pq;
        private int curr;

        public SeatManager(int n) {
            pq = new PriorityQueue<>();
            curr = 1;
        }

        public int reserve() {
            if (pq.isEmpty())
                return curr++;
            return pq.poll();
        }

        public void unreserve(int seatNumber) {
            pq.offer(seatNumber);
        }
    }
}
