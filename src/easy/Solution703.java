package easy;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution703 {
    class KthLargest {

        private PriorityQueue<Integer> pq;
        private int k;

        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>(IntStream.of(nums).boxed().toList());
            this.k = k;
            while (pq.size() > k)
                pq.poll();
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k)
                pq.poll();
            return pq.peek();
        }
    }
}
