package medium;

// 921. Minimum Add to Make Parentheses Valid

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution921 {
    public int minAddToMakeValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty()) {
                if (c == ')' && st.peek() == '(') {
                    st.pop();
                    continue;
                }
            }
            st.push(c);
        }

        return st.size();
    }
}
