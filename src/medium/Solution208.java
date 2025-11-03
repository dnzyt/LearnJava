package medium;

// 208. Implement Trie (Prefix Tree)


public class Solution208 {
    class Node {
        public Node[] children;
        public boolean isEnd;
    }

    class Trie {
        public Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new Node();
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            return find(word) == 1;
        }

        public boolean startsWith(String prefix) {
            return find(prefix) != 0;
        }

        private int find(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    return 0;
                curr = curr.children[c - 'a'];
            }
            return curr.isEnd ? 1 : 2;
        }
    }

}
