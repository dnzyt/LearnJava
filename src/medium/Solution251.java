package medium;

// 251. Flatten 2D Vector

import java.util.ArrayList;
import java.util.List;

public class Solution251 {
    class Vector2D {
        private List<Integer> l;
        private int idx;

        public Vector2D(int[][] vec) {
            l = new ArrayList<>();
            for (int[] row : vec) {
                for (int num : row)
                    l.add(num);
            }
        }

        public int next() {
            int ans = l.get(idx);
            idx++;
            return ans;
        }

        public boolean hasNext() {
            return idx < l.size();
        }
    }
}
