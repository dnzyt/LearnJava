package medium;

// 677. Map Sum Pairs

public class Solution677 {
    class Node {
        public Node[] children;
        public int score;

        public Node() {
            children = new Node[26];
            score = 0;
        }
    }

    class MapSum {
        private Node root;

        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            Node curr = root;
            for (char c : key.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new Node();
                curr = curr.children[c - 'a'];
            }
            curr.score = val;
        }

        public int sum(String prefix) {
            Node t = findRoot(prefix);
            if (t == null)
                return 0;
            return dfs(t);
        }

        private Node findRoot(String prefix) {
            Node curr = root;
            for (char c : prefix.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    return null;
                curr = curr.children[c - 'a'];
            }
            return curr;
        }

        private int dfs(Node root) {
            int ans = root.score;
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null)
                    ans += dfs(root.children[i]);
            }
            return ans;
        }
    }
}
