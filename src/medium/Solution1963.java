package medium;

// 1963. Minimum Number of Swaps to Make the String Balanced

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1963 {
    public int minSwaps(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && c == ']' && st.peek() == '[')
                st.pop();
            else
                st.push(c);
        }
        return (st.size() / 2 + 1) / 2;
    }
}
