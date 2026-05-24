package medium;

// 3926. Count Valid Word Occurrences

import java.util.HashMap;
import java.util.Map;

public class Solution3926 {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        String s = String.join("", chunks);
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : s.split(" ")) {
            int i = 0;
            while (i < word.length()) {
                if (word.charAt(i) == '-') {
                    i++;
                    continue;
                }
                int start = i;
                while (i < word.length() && (word.charAt(i) != '-' || (i + 1 < word.length() && word.charAt(i + 1) != '-')))
                    i++;
                cnt.merge(word.substring(start, i), 1, Integer::sum);
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
            ans[i] = cnt.getOrDefault(queries[i], 0);
        return ans;
    }
}
