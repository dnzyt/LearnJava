package medium;

// 71. Simplify Path

import java.util.ArrayList;
import java.util.List;

public class Solution71 {
    public String simplifyPath(String path) {
        List<String> st = new ArrayList<>();
        for (String s : path.split("/")) {
            if (s.isEmpty() || s.equals("."))
                continue;
            if (!s.equals("..")) {
                st.add(s);
            } else if (!st.isEmpty()) {
                st.remove(st.size() - 1);
            }
        }
        return "/" + String.join("/", st);
    }
}
