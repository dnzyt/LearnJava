package medium;

// 421. Maximum XOR of Two Numbers in an Array

public class Solution421 {
    class Node {
        public Node[] children;

        public Node() {
            children = new Node[2];
        }
    }


    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        for (int num : nums) {
            Node curr = root;
            for (int i = 31; i >= 0; i--) {
                int d = num & (1 << i);
                if (curr.children[d] == null)
                    curr.children[d] = new Node();
                curr = curr.children[d];
            }
        }
        int ans = 0;
        for (int num : nums) {
            Node curr = root;
            int temp = 0;
            for (int i = 31; i >= 0; i--) {
                int d = num & (1 << i);
                if (curr.children[d ^ 1] == null) {
                    curr = curr.children[d];
                } else {
                    temp |= (1 << i);
                    curr = curr.children[d ^ 1];
                }
            }
            ans = Math.max(ans, temp);
        }

        return ans;
    }

}
