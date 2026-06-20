package easy;

// 2325. Decode the Message

import java.util.HashMap;
import java.util.Map;

public class Solution2325 {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        map.put(' ', ' ');
        char start = 'a';
        for (char ch : key.toCharArray()) {
            if (map.containsKey(ch))
                continue;
            map.put(ch, start);
            start = (char) (start + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : message.toCharArray())
            sb.append(map.get(ch));
        return sb.toString();
    }
}
