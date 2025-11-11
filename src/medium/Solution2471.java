package medium;

// 2471. Minimum Number of Operations to Sort a Binary Tree by Level

import util.TreeNode;
import util.UnionFind;

import java.util.*;
import java.util.stream.IntStream;

public class Solution2471 {
    public int minimumOperations(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Deque<TreeNode> temp = new ArrayDeque<>();
            List<Integer> nums = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                nums.add(node.val);
                if (node.left != null)
                    temp.add(node.left);
                if (node.right != null)
                    temp.add(node.right);
            }
            // calculate swaps
            ans += calculateSwap(nums.stream().mapToInt(Integer::intValue).toArray());
            q = temp;
        }
        return ans;
    }

    private int calculateSwap(int[] nums) {
        int n = nums.length;
        UnionFind uf = new UnionFind(n);
        List<int[]> s = IntStream.range(0, n).mapToObj(i -> new int[]{nums[i], i}).sorted(Comparator.comparingInt(a -> a[0])).toList();
        for (int i = 0; i < s.size(); i++)
            uf.merge(i, s.get(i)[1]);
        return nums.length - uf.count;
    }
}
