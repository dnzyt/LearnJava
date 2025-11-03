package medium;

// 648. Replace Words

import java.util.List;

public class Solution648 {
    class Node {
        public Node[] children;
        public boolean isEnd;

        public Node() {
            children = new Node[26];
            isEnd = false;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        Node root = new Node();
        Node curr;

        for (String prefix : dictionary) {
            curr = root;
            for (char c : prefix.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new Node();
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            StringBuilder sb = new StringBuilder();
            curr = root;
            for (char c : w.toCharArray()) {
                sb.append(c);
                if (curr.children[c - 'a'] == null) {
                    curr = null;
                    break;
                } else {
                    curr = curr.children[c - 'a'];
                    if (curr.isEnd)
                        break;
                }
            }
            if (curr == null || !curr.isEnd)
                continue;
            words[i] = sb.toString();
        }
        return String.join(" ", words);
    }
}
