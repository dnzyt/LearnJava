package hard;

// 1803. Count Pairs With XOR in a Range

public class Solution1803 {

    class TrieNode {
        public TrieNode[] children;
        public int cnt;

        public TrieNode() {
            children = new TrieNode[2];
            cnt = 0;
        }
    }

    public int countPairs(int[] nums, int low, int high) {

        TrieNode root = new TrieNode();
        int ans = 0;
        for (int num : nums) {
            ans += getLessOrEqual(root, num, high) - getLessOrEqual(root, num, low - 1);
            TrieNode curr = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (curr.children[bit] == null)
                    curr.children[bit] = new TrieNode();
                curr.children[bit].cnt++;
                curr = curr.children[bit];
            }
        }
        return ans;

    }

    public int getLessOrEqual(TrieNode root, int num, int threshold) {
        int ans = 0;
        TrieNode curr = root;
        for (int i = 31; i >= 0; i--) {
            if (curr == null)
                return ans;
            int c = (threshold >> i) & 1;
            int b = (num >> i) & 1;

            if (c == 0) {
                curr = curr.children[b];

            } else {
                ans += curr.children[b].cnt;
                curr = curr.children[b ^ 1];
            }
        }
        return curr == null ? ans : ans + curr.cnt;
    }


}
