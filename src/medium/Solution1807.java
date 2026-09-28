package medium;

// 1807. Evaluate the Bracket Pairs of a String

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>(knowledge.size());
        for (List<String> x : knowledge) {
            String k = x.get(0);
            String v = x.get(1);
            map.put(k, v);
        }
        StringBuilder sb = new StringBuilder();
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left = i + 1;
            } else if (c == ')') {
                String t = s.substring(left, i);
                sb.append(map.getOrDefault(t, "?"));
                left = -1;
            } else {
                if (left < 0)
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}
