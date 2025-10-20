package medium;

// 844. Backspace String Compare

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> ss = new ArrayDeque<>();
        Deque<Character> tt = new ArrayDeque<>();
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        for (char c : s1) {
            if (c == '#') {
                if (!ss.isEmpty())
                    ss.pop();
            } else {
                ss.push(c);
            }
        }
        for (char c : t1) {
            if (c == '#') {
                if (!tt.isEmpty())
                    tt.pop();
            } else {
                tt.push(c);
            }
        }
        if (ss.size() != tt.size()) return false;
        while (!ss.isEmpty()) {
            if (ss.pop() != tt.pop())
                return false;
        }
        return true;
    }
}
