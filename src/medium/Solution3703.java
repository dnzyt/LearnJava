package medium;

// 3703. Remove K-Balanced Substrings

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3703 {
    public String removeSubstring(String s, int k) {
        List<Pair<Character, Integer>> st = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (st.isEmpty())
                st.add(new Pair<>(c, 1));
            else {
                Pair<Character, Integer> last = st.remove(st.size() - 1);
                if (last.getKey() == c) {
                    st.add(new Pair<>(c, last.getValue() + 1));
                } else {
                    st.add(last);
                    st.add(new Pair<>(c, 1));
                }
            }
            if (st.size() > 1 &&
                    st.get(st.size() - 1).getKey() == ')' &&
                    st.get(st.size() - 1).getValue() >= k &&
                    st.get(st.size() - 2).getValue() >= k) {
                Pair<Character, Integer> first = st.remove(st.size() - 1);
                Pair<Character, Integer> second = st.remove(st.size() - 1);
                if (second.getValue() - first.getValue() > 0) {
                    st.add(new Pair<>(second.getKey(), second.getValue() - first.getValue()));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Pair<Character, Integer> p : st) {
            char[] c = new char[p.getValue()];
            Arrays.fill(c, p.getKey());
            sb.append(c);
        }
        return sb.toString();
    }
}
