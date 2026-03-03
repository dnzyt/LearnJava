package medium;

// 3853. Merge Close Characters

import java.util.*;

public class Solution3853 {
    public String mergeCharacters(String s, int k) {
        int n = s.length();
        byte[] marked = new byte[n];
        int numOfMarked = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < n; right++) {
            if (set.contains(s.charAt(right))) {
                marked[right] = 1;
                numOfMarked++;
            } else {
                set.add(s.charAt(right));
            }
            while (marked[left] == 1 || right - left - numOfMarked >= k) {
                if (marked[left] == 0) {
                    set.remove(s.charAt(left));
                } else {
                    numOfMarked--;
                }
                left++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            if (marked[i] == 0)
                sb.append(s.charAt(i));
        return sb.toString();
    }

    public String mergeCharacters2(String s, int k) {
        List<Character> ans = new ArrayList<>();
        Map<Character, Integer> lastPos = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (!lastPos.containsKey(ch) || ans.size() - lastPos.get(ch) > k) {
                lastPos.put(ch, ans.size());
                ans.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char x : ans)
            sb.append(x);
        return sb.toString();
    }
}
