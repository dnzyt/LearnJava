package easy;

// 1021. Remove Outermost Parentheses

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution1021 {
    public String removeOuterParentheses(String s) {
        char[] chs = s.toCharArray();
        int n = s.length();
        Deque<Integer> st = new ArrayDeque<>();
        List<int[]> p = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (st.isEmpty()) {
                st.push(i);
                continue;
            }
            if (chs[i] == ')') {
                int start = st.pop();
                if (st.size() == 0)
                    p.add(new int[]{start, i});
            } else
                st.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int[] x : p) {
            sb.append(s, x[0] + 1, x[1]);
        }
        return sb.toString();
    }
}
