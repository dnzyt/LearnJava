package easy;

// 1614. Maximum Nesting Depth of the Parentheses

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1614 {
    public int maxDepth(String s) {
        Deque<Character> st = new ArrayDeque<>();
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                st.push(c);
            else if (c == ')') {
                ans = Math.max(ans, st.size());
                st.pop();
            }
        }
        return ans;
    }
}
