package medium;

// 1792. Maximum Average Pass Ratio

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        record Node(double gain, int a, int b) {
        }
        // gain = (a + 1)/(b + 1)-a/b = (b - a)/b(b + 1)
        // 把每次加1的机会交给增益最大的班

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> -a.gain));
        for (int[] c : classes) {
            int a = c[0];
            int b = c[1];
            double gain = 1.0 * (b - a) / ((long) b * (b + 1));
            pq.offer(new Node(gain, a, b));
        }

        while (extraStudents-- > 0) {
            Node c = pq.poll();
            int a = c.a + 1;
            int b = c.b + 1;
            double gain = 1.0 * (b - a) / ((long) b * (b + 1));
            pq.offer(new Node(gain, a, b));
        }
        double sum = 0;
        for (Node c : pq) {
            sum += 1.0 * c.a / c.b;
        }
        return sum / classes.length;
    }
}
