package medium;

// 316. Remove Duplicate Letters

import java.util.*;

public class Solution316 {
    public String removeDuplicateLetters(String s) {
        char[] letters = s.toCharArray();
        Set<Character> visited = new HashSet<>();
        Map<Character, Integer> counter = new HashMap<>();
        for (char ch : letters) {
            int cnt = 0;
            if (counter.containsKey(ch))
                cnt = counter.get(ch);
            counter.put(ch, cnt + 1);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!visited.contains(letters[i])) {
                while (!stack.empty() && letters[stack.peek()] > letters[i] && counter.get(letters[stack.peek()]) > 0) {
                    Character curr = letters[stack.pop()];
                    visited.remove(curr);
                }
                stack.add(i);
                visited.add(letters[i]);
            }
            int cnt = counter.get(letters[i]);
            counter.put(letters[i], cnt - 1);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(letters[stack.pop()]);
        }
        sb.reverse();
        return sb.toString();

    }
}
