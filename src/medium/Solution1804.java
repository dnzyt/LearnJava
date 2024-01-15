package medium;

// 1804. Implement Trie II (Prefix Tree)

public class Solution1804 {
    static class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            this.nexts = new TrieNode[26];
        }
    }


    static class Trie {

        public TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = this.root;
            node.pass += 1;
            for (int i = 0; i < word.length(); i++) {
                if (node.nexts[word.charAt(i) - 'a'] == null)
                    node.nexts[word.charAt(i) - 'a'] = new TrieNode();
                node = node.nexts[word.charAt(i) - 'a'];
                node.pass += 1;
            }
            node.end += 1;
        }

        public int countWordsEqualTo(String word) {
            TrieNode node = this.root;
            for (int i = 0; i < word.length(); i++) {
                node = node.nexts[word.charAt(i) - 'a'];
                if (node == null)
                    return 0;
            }
            return node.end;
        }

        public int countWordsStartingWith(String prefix) {
            TrieNode node = this.root;
            for (int i = 0; i < prefix.length(); i++) {
                node = node.nexts[prefix.charAt(i) - 'a'];
                if (node == null)
                    return 0;
            }

            return node.pass;
        }

        public void erase(String word) {
            if (countWordsEqualTo(word) <= 0) return;
            TrieNode node = this.root;
            node.pass -= 1;
            for (int i = 0; i < word.length(); i++) {
                TrieNode nxt = node.nexts[word.charAt(i) - 'a'];
                nxt.pass -= 1;
                if (nxt.pass == 0) {
                    node.nexts[word.charAt(i) - 'a'] = null;
                    return;
                }
                node = nxt;
            }
            node.end -= 1;
        }
    }
}
