package easy;

// 804. Unique Morse Code Words

import java.util.HashSet;
import java.util.Set;

public class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> s = new HashSet<>();
        String[] mappings = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray())
                sb.append(mappings[c - 'a']);
            s.add(sb.toString());
        }
        return s.size();
    }
}
