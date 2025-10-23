package medium;

import java.util.ArrayList;
import java.util.List;

// 2434. Using a Robot to Print the Lexicographically Smallest String

public class Solution2434 {
    public String robotWithString(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        char[] rightSmallest = new char[n];
        rightSmallest[n - 1] = chs[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightSmallest[i] = (char) Math.min(chs[i], rightSmallest[i + 1]);
        }
        StringBuilder sb = new StringBuilder();
        List<Character> st = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.get(st.size() - 1) <= rightSmallest[i]) {
                char last = st.remove(st.size() - 1);
                sb.append(last);
            }
            st.add(chs[i]);
        }
        while (!st.isEmpty()) {
            sb.append(st.remove(st.size() - 1));
        }
        return sb.toString();
    }
}
