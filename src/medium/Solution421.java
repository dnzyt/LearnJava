package medium;

// 421. Maximum XOR of Two Numbers in an Array

import java.util.HashSet;
import java.util.Set;

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

    // 试填法
    public int findMaximumXOR2(int[] nums) {
        int n = nums.length;
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums)
            maxVal = Math.max(maxVal, num);

        int width = 32 - Integer.numberOfLeadingZeros(maxVal);

        int ans = 0;
        Set<Integer> seen = new HashSet<>();
        int highBits = 0;
        for (int i = width - 1; i >= 0; i--) {
            int target = ans | (1 << i);
            highBits |= (1 << i);
            seen.clear();
            for (int j = 0; j < n; j++) {
                int x = nums[j] & highBits;
                if (seen.contains(target ^ x)) {
                    ans = target;
                    break;
                }
                seen.add(x);
            }
        }
        return ans;
    }
}
