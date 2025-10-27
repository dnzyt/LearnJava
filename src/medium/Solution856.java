package medium;

// 856. Score of Parentheses

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution856 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        for (char c : s.toCharArray()) {
            if (c == ')') {
                int l = st.pop();
                if (l == 0) {
                    st.push(st.pop() + 1);
                } else {
                    st.push(st.pop() + l * 2);
                }
            } else {
                st.push(0);
            }
        }
        return st.pop();
    }
}
