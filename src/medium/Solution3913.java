package medium;

// 3913. Sort Vowels by Frequency

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3913 {
    public String sortVowels(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        List<Character> vowels = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if ("aeiou".indexOf(ch) < 0)
                continue;
            if (!cnt.containsKey(ch)) {
                vowels.add(ch);
            }
            cnt.merge(ch, 1, Integer::sum);
        }
        vowels.sort((a, b) -> cnt.get(b) - cnt.get(a));
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (char ch : s.toCharArray()) {
            if ("aeiou".indexOf(ch) < 0)
                sb.append(ch);
            else {
                sb.append(vowels.get(i));
                int num = cnt.get(vowels.get(i));
                num--;
                if (num == 0) {
                    i++;
                } else {
                    cnt.put(vowels.get(i), num);
                }

            }
        }
        return sb.toString();
    }
}
