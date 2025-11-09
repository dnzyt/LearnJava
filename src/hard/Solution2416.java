package hard;

// 2416. Sum of Prefix Scores of Strings

public class Solution2416 {
    class Node {
        public Node[] children;
        public int score;

        public Node() {
            children = new Node[26];
            score = 0;
        }
    }

    public int[] sumPrefixScores(String[] words) {
        Node root = new Node();
        Node curr;
        int n = words.length;
        int[] ans = new int[n];

        for (String word : words) {
            curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new Node();
                curr.children[c - 'a'].score++;
                curr = curr.children[c - 'a'];
            }
        }

        for (int i = 0; i < n; i++) {
            String word = words[i];
            curr = root;
            int s = 0;
            for (char c : word.toCharArray()) {
                s += curr.children[c - 'a'].score;
                curr = curr.children[c - 'a'];
            }
            ans[i] = s;
        }


        return ans;
    }
}
