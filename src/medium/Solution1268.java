package medium;

// 1268. Search Suggestions System

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1268 {
    class Node {
        public Node[] children;
        public boolean isWord;

        public Node() {
            children = new Node[26];
            isWord = false;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Node root = new Node();
        for (String word : products) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new Node();
                curr = curr.children[c - 'a'];
            }
            curr.isWord = true;
        }
        Node curr = root;
        for (int i = 0; i < searchWord.length(); i++) {
            curr = curr.children[searchWord.charAt(i) - 'a'];
            if (curr == null) {
                ans.addAll(Collections.nCopies(searchWord.length() - i, Collections.emptyList()));
                break;
            }
            ans.add(dfs(searchWord.substring(0, i + 1), curr));
        }
        return ans;
    }

    private List<String> dfs(String prefix, Node root) {
        List<String> ans = new ArrayList<>();
        if (root.isWord)
            ans.add(prefix);
        for (int i = 0; i < 26; i++) {
            if (root.children[i] == null)
                continue;
            List<String> t = dfs(prefix + String.valueOf((char) ('a' + i)), root.children[i]);
            ans.addAll(t);
            if (ans.size() >= 3)
                return ans.stream().limit(3).toList();
        }
        return ans;
    }
}
