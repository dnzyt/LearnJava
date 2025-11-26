package medium;

// 1361. Validate Binary Tree Nodes

import java.util.*;

public class Solution1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        int[] inDeg = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                g[i].add(leftChild[i]);
                inDeg[leftChild[i]]++;
                if (inDeg[leftChild[i]] > 1)
                    return false;
            }
            if (rightChild[i] != -1) {
                g[i].add(rightChild[i]);
                inDeg[rightChild[i]]++;
                if (inDeg[rightChild[i]] > 1)
                    return false;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }
        if (q.size() != 1)
            return false;

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);
            for (int nxt : g[curr]) {
                inDeg[nxt]--;
                if (inDeg[nxt] == 0)
                    q.offer(nxt);
            }
        }
        return ans.size() == n;
    }
}
