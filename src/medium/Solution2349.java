package medium;

// 2349. Design a Number Container System

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution2349 {
    // 懒删除堆
    class NumberContainers {
        Map<Integer, Integer> i2n;
        Map<Integer, PriorityQueue<Integer>> n2i;

        public NumberContainers() {
            i2n = new HashMap<>();
            n2i = new HashMap<>();
        }

        public void change(int index, int number) {
            i2n.put(index, number);
            if (n2i.get(number) == null)
                n2i.put(number, new PriorityQueue<>());
            n2i.get(number).offer(index);
        }

        public int find(int number) {
            PriorityQueue<Integer> q = n2i.get(number);
            if (q == null)
                return -1;
            while (!q.isEmpty() && i2n.get(q.peek()) != number)
                q.poll();
            return q.isEmpty() ? -1 : q.peek();
        }
    }
}
