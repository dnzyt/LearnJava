package easy;

// 2788. Split Strings by Separator

import java.util.ArrayList;
import java.util.List;

public class Solution2778 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (ch == separator) {
                    if (!sb.isEmpty()) {
                        ans.add(sb.toString());
                        sb.setLength(0);
                    }
                } else {
                    sb.append(ch);
                }
            }
            if (!sb.isEmpty())
                ans.add(sb.toString());
            sb.setLength(0);
        }
        return ans;
    }
}
