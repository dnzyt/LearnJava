package easy;

// 1047. Remove All Adjacent Duplicates In String

import java.util.ArrayList;
import java.util.List;

public class Solution1047 {
    public String removeDuplicates(String s) {
        List<Character> st = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (st.isEmpty()) {
                st.add(c);
            } else {
                if (st.get(st.size() - 1) == c)
                    st.remove(st.size() - 1);
                else
                    st.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }
        return sb.toString();
    }
}
