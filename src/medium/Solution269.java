package medium;

// 269. Alien Dictionary

import java.util.*;

public class Solution269 {

    private int[] head;
    private int[] next;
    private int[] to;
    private int cnt = 1;
    private int[] indegree;
    private int[] queue;

    public String alienOrder(String[] words) {
        head = new int[26 + 1];
        next = new int[26 * 26 + 1];
        to = new int[26 + 1];
        indegree = new int[26 + 1];
        Arrays.fill(indegree, -1);
        for (String word : words) {
            for (char c : word.toCharArray())
                indegree[c - 'a' + 1] = 0;
        }
        queue = new int[26];
        for (int i = 0; i < words.length - 1; i++) {
            String x = words[i], y = words[i + 1];
            if (x.length() > y.length() && y.equals(x.substring(0, y.length())))
                return "";
            for (int j = 0; j < Math.min(x.length(), y.length()); j++) {
                int a = x.charAt(j) - 'a' + 1;
                int b = y.charAt(j) - 'a' + 1;
                if (a == b)
                    continue;
                addEdge(a, b);
                indegree[b]++;
                break;
            }
        }
        int l = 0, r = 0;
        int numOfChars = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] != -1)
                numOfChars++;
            if (indegree[i] == 0)
                queue[r++] = i;
        }

        StringBuilder sb = new StringBuilder();
        while (l < r) {
            int curr = queue[l++];
            sb.append((char) (curr + 'a' - 1));
            for (int ei = head[curr]; ei > 0; ei = next[ei]) {
                int nxt = to[ei];
                if (--indegree[nxt] == 0)
                    queue[r++] = nxt;
            }
        }
        return sb.length() == numOfChars ? sb.toString() : "";
    }


    private void addEdge(int a, int b) {
        next[cnt] = head[a];
        to[cnt] = b;
        head[a] = cnt++;
    }
}
