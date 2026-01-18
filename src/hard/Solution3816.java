package hard;

// 3816. Lexicographically Smallest String After Deleting Duplicate Characters

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3816 {
    public String lexSmallestAfterDeletion(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray())
            cnt[c - 'a']++;
        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            while (!st.isEmpty() && st.peek() > curr && cnt[st.peek() - 'a'] > 1)
                cnt[st.pop() - 'a']--;
            st.push(curr);

        }
        while (cnt[st.peek() - 'a'] > 1)
            cnt[st.pop() - 'a']--;

        StringBuilder sb = new StringBuilder();
        for (char c : st)
            sb.append(c);
        sb.reverse();
        return sb.toString();
    }
}
