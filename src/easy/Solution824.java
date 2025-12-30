package easy;

// 824. Goat Latin

import java.util.ArrayList;
import java.util.List;

public class Solution824 {
    public String toGoatLatin(String sentence) {
        String[] parts = sentence.split(" ");
        List<String> ans = new ArrayList<>();
        int idx = 1;
        for (String s : parts) {
            if ("aeiouAEIOU".indexOf(s.charAt(0)) == -1) {
                ans.add(s.substring(1, s.length()) + s.substring(0, 1) + "ma" + "a".repeat(idx));
            } else {
                ans.add(s + "ma" + "a".repeat(idx));
            }
            idx++;
        }
        return String.join(" ", ans.toArray(new String[0]));
    }
}
