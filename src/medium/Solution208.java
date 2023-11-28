package medium;

// 208. Implement Trie (Prefix Tree)

import java.util.HashMap;
import java.util.Map;

public class Solution208 {
    static class TrieNode {
        private Map<Character, TrieNode> node;
        private boolean isEnd;

        public TrieNode() {
            this.node = new HashMap<>();
            this.isEnd = false;
        }
        public boolean contains(Character w) {
            return node.containsKey(w);
        }
        public void add(Character w) {
            if (!this.contains(w))
                node.put(w, new TrieNode());
        }
        public TrieNode getNext(Character w) {
            return node.get(w);
        }

        public void endWord() {
            this.isEnd = true;
        }

        public boolean isWord() {
            return this.isEnd;
        }
    }

    static class Trie {
        private TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (Character w : word.toCharArray()) {
                if (!curr.contains(w))
                    curr.add(w);
                curr = curr.getNext(w);
            }
            curr.endWord();
        }

        public boolean search(String word) {
            TrieNode curr = root;
            for (Character w : word.toCharArray()) {
                if (curr.getNext(w) == null)
                    return false;
                curr = curr.getNext(w);
            }
            return curr.isWord();
        }

        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for (Character w : prefix.toCharArray()) {
                if (curr.getNext(w) == null)
                    return false;
                curr = curr.getNext(w);
            }
            return curr != null;
        }
    }

}
