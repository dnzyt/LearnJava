package easy;

// 20. Valid Parentheses

import java.util.ArrayList;
import java.util.List;

public class Solution20 {
    public boolean isValid(String s) {
        List<Character> st = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c == ')' || c == ']' || c == '}') {
                if (st.isEmpty()) return false;
                char last = st.remove(st.size() - 1);
                if (c == ')' && last != '(') return false;
                if (c == ']' && last != '[') return false;
                if (c == '}' && last != '{') return false;
            } else {
                st.add(c);
            }
        }
        return st.isEmpty();
    }
}
