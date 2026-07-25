package medium;

// 316. Remove Duplicate Letters

import java.util.*;

public class Solution316 {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        boolean[] visited = new boolean[26];
        char[] chs = s.toCharArray();
        for (char c : chs)
            cnt[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (char c : chs) {
            cnt[c - 'a']--;
            if (visited[c - 'a'])
                continue;
            while (!sb.isEmpty() && cnt[sb.charAt(sb.length() - 1) - 'a'] > 0 && sb.charAt(sb.length() - 1) > c) {
                char last = sb.charAt(sb.length() - 1);
                visited[last - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            visited[c - 'a'] = true;
            sb.append(c);
        }
        return sb.toString();
    }
}
