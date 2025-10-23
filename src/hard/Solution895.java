package hard;

// 895. Maximum Frequency Stack

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution895 {
    class FreqStack {

        private List<List<Integer>> freq;
        private Map<Integer, Integer> map;

        public FreqStack() {
            freq = new ArrayList<>();
            freq.add(new ArrayList<>());
            map = new HashMap<>();
        }

        public void push(int val) {
            int f = map.getOrDefault(val, 0);
            f++;
            if (f == freq.size()) {
                freq.add(new ArrayList<>());
            }
            freq.get(f).add(val);
            map.put(val, f);
        }

        public int pop() {
            int f = freq.size() - 1;
            List<Integer> l = freq.get(f);
            int res = l.remove(l.size() - 1);
            f--;
            if (f == 0) {
                map.remove(res);
            } else {
                map.put(res, f);
            }
            if (l.isEmpty())
                freq.remove(freq.size() - 1);
            return res;
        }
    }
}
