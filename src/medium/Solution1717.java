package medium;

// 1717. Maximum Score From Removing Substrings

import java.util.ArrayList;
import java.util.List;

public class Solution1717 {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            String t1 = match(s, 'a', 'b');
            String t2 = match(t1, 'b', 'a');
            return ((s.length() - t1.length()) / 2) * x + ((t1.length() - t2.length()) / 2) * y;
        } else {
            String t1 = match(s, 'b', 'a');
            String t2 = match(t1, 'a', 'b');
            return ((s.length() - t1.length()) / 2) * y + ((t1.length() - t2.length()) / 2) * x;
        }
    }

    private String match(String s, char a, char b) {
        List<Character> st = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (st.isEmpty()) {
                st.add(c);
                continue;
            }
            if (c == b && st.get(st.size() - 1) == a) {
                st.remove(st.size() - 1);
            } else {
                st.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : st)
            sb.append(c);
        return sb.toString();
    }

}
