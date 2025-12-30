package easy;

// 748. Shortest Completing Word

import java.util.HashMap;
import java.util.Map;

public class Solution748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : licensePlate.toCharArray()) {
            if (c >= 97 && c <= 122) {
                cnt.merge(c, 1, Integer::sum);
            }
        }
        String ans = "";
        for (String s : words) {
            Map<Character, Integer> cntWord = new HashMap<>();
            for (char c : s.toCharArray()) {
                cntWord.merge(c, 1, Integer::sum);
            }
            boolean findWord = true;
            for (Character k : cnt.keySet()) {
                if (!cntWord.containsKey(k) || cntWord.get(k) < cnt.get(k)) {
                    findWord = false;
                    break;
                }
            }
            if (findWord) {
                if (ans.equals("")) {
                    ans = s;
                } else {
                    if (ans.length() > s.length())
                        ans = s;
                }
            }
        }
        return ans;
    }
}
