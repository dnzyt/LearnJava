package medium;

// 1209. Remove All Adjacent Duplicates in String II

import java.util.ArrayList;
import java.util.List;

public class Solution1209 {
    public String removeDuplicates(String s, int k) {
        List<List<Character>> f = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (f.size() - 1 < 0) {
                List<Character> x = new ArrayList<>();
                x.add(c);
                f.add(x);
                continue;
            }
            List<Character> row = f.get(f.size() - 1);
            char last = row.get(row.size() - 1);
            if (c == last) {
                row.add(c);
                if (row.size() == k) {
                    f.remove(f.size() - 1);
                }
            } else {
                List<Character> x = new ArrayList<>();
                x.add(c);
                f.add(x);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> x : f)
            for (char c : x)
                sb.append(c);
        return sb.toString();
    }
}
