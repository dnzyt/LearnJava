package medium;

// 2424. Longest Uploaded Prefix

import java.util.HashSet;
import java.util.Set;

public class Solution2424 {
    class LUPrefix {

        private int x;
        private Set<Integer> s;

        public LUPrefix(int n) {
            this.x = 1;
            this.s = new HashSet<>();
        }

        public void upload(int video) {
            s.add(video);
        }

        public int longest() {
            while (s.contains(x))
                x++;
            return x - 1;
        }
    }
}
