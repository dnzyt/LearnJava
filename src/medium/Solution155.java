package medium;

// 155. Min Stack

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution155 {
    static class MinStack {
        private List<Integer> minSt;
        private List<Integer> st;

        public MinStack() {
            minSt = new ArrayList<>();
            st = new ArrayList<>();
        }

        public void push(int val) {
            st.add(val);
            if (minSt.isEmpty()) {
                minSt.add(val);
            } else if (minSt.get(minSt.size() - 1) >= val) {
                minSt.add(val);
            }
        }

        public void pop() {
            int val = st.get(st.size() - 1);
            st.remove(st.size() - 1);
            if (minSt.get(minSt.size() - 1) == val) {
                minSt.remove(minSt.size() - 1);
            }
        }

        public int top() {
            return st.get(st.size() - 1);
        }

        public int getMin() {
            return minSt.get(minSt.size() - 1);
        }

    }


}
