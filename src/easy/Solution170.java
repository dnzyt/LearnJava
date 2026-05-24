package easy;

// 170. Two Sum III - Data structure design

import java.util.HashMap;
import java.util.Map;

public class Solution170 {
    class TwoSum {
        private Map<Integer, Integer> cnt;

        public TwoSum() {
            cnt = new HashMap<>();
        }

        public void add(int number) {
            cnt.merge(number, 1, Integer::sum);
        }

        public boolean find(int value) {
            for (int key : cnt.keySet()) {
                int t = value - key;
                if (t == key && cnt.get(key) > 1)
                    return true;
                if (t != key && cnt.getOrDefault(t, 0) > 0)
                    return true;
            }
            return false;
        }
    }
}
