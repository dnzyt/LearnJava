package medium;

// 2336. Smallest Number in Infinite Set

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution2336 {
    class SmallestInfiniteSet {
        private PriorityQueue<Integer> pq;
        private int curr;
        private Set<Integer> s;

        public SmallestInfiniteSet() {
            pq = new PriorityQueue<>();
            s = new HashSet<>();
            curr = 1;
        }

        public int popSmallest() {
            if (pq.isEmpty())
                return curr++;
            int res = pq.poll();
            s.remove(res);
            return res;
        }

        public void addBack(int num) {
            if (num < curr) {
                if (!s.contains(num)) {
                    pq.offer(num);
                    s.add(num);
                }
            }
        }
    }
}
