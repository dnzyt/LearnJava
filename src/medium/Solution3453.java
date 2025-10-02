package medium;

// 3453. Separate Squares I

import java.util.Map;
import java.util.TreeMap;

public class Solution3453 {
    public double separateSquares(int[][] squares) {
        TreeMap<Integer, Long> diff = new TreeMap<>();
        long total = 0;
        for (int[] s : squares) {
            int y = s[1];
            long l = s[2];
            diff.merge(y, l, Long::sum);
            diff.merge(y + (int) l, -l, Long::sum);
            total += l * l;
        }

        long sumL = 0;
        int preY = 0;
        long area = 0;
        for (Map.Entry<Integer, Long> e : diff.entrySet()) {
            int y = e.getKey();
            area += (y - preY) * sumL;
            if (area * 2 >= total) {
                return y - (area * 2 - total) / (sumL * 2.0);
            }
            sumL += e.getValue();
            preY = y;
        }
        return -1;
    }

}
