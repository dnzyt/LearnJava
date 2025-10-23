package easy;

// 2696. Minimum String Length After Removing Substrings

import java.util.ArrayList;
import java.util.List;

public class Solution2696 {
    public int minLength(String s) {
        char[] chs = s.toCharArray();
        List<Character> st = new ArrayList<>();
        for (char c : chs) {
            if (st.isEmpty()) {
                st.add(c);
            } else {
                char last = st.get(st.size() - 1);
                if (last == 'A' && c == 'B') {
                    st.remove(st.size() - 1);
                } else if (last == 'C' && c == 'D') {
                    st.remove(st.size() - 1);
                } else {
                    st.add(c);
                }
            }
        }
        return st.size();
    }
}
