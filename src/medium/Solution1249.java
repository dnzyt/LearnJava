package medium;

// 1249. Minimum Remove to Make Valid Parentheses

import java.util.*;

public class Solution1249 {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        Deque<Integer> st = new ArrayDeque<>();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (chs[i] == '(')
                st.push(i);
            else if (chs[i] == ')') {
                if (st.isEmpty())
                    l.add(i);
                else
                    st.pop();
            }
        }
        l.addAll(st);
        Collections.sort(l);
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>(l);

        for (int i = 0; i < n; i++) {
            if (!set.contains(i))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
