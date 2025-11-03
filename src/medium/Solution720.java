package medium;

// 720. Longest Word in Dictionary

import java.util.Arrays;
import java.util.Comparator;

public class Solution720 {
    class Node {
        public Node[] children;

        public Node() {
            children = new Node[26];
        }
    }

    public String longestWord(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length).thenComparing(String::compareTo));
        Node root = new Node();
        Node curr;

        String ans = "";
        for (String word : words) {
            curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    if (i == word.length() - 1) {
                        curr.children[c - 'a'] = new Node();
                        ans = ans.length() < word.length() ? word : ans;
                    }
                    break;
                } else {
                    curr = curr.children[c - 'a'];
                }
            }
        }
        return ans;
    }
}
