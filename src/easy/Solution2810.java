package easy;

// 2810. Faulty Keyboard

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2810 {
    public String finalString(String s) {
        boolean tail = true;
        Deque<Character> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == 'i')
                tail = !tail;
            else if (tail)
                q.offer(c);
            else
                q.offerFirst(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : q)
            sb.append(c);
        if (!tail)
            sb.reverse();
        return sb.toString();
    }
}
