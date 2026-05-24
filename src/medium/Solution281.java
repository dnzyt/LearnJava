package medium;

// 281. Zigzag Iterator

import java.util.List;

public class Solution281 {
    class ZigzagIterator {
        private int curr;
        private int idx1;
        private int idx2;
        private List<Integer>[] v;


        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            v = new List[2];
            if (v1.size() == 0) {
                v[0] = v2;
                v[1] = v1;
            } else {
                v[0] = v1;
                v[1] = v2;
            }
        }

        public int next() {
            int ans = v[curr].get((curr == 0) ? idx1 : idx2);
            if (curr == 0) {
                idx1++;
                if (idx2 != v[1].size())
                    curr = 1;
            } else {
                idx2++;
                if (idx1 != v[0].size())
                    curr = 0;
            }
            return ans;

        }

        public boolean hasNext() {
            return (idx1 + idx2) != (v[0].size() + v[1].size());
        }
    }
}
