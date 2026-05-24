package medium;

// 1871. Jump Game VII

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1871 {
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] chs = s.toCharArray();
        int n = s.length();
        boolean[] visited = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visited[0] = true;

        int mx = 0;
        while (!q.isEmpty()) {
            int k = q.size();
            while (k-- > 0) {
                int curr = q.poll();
                for (int nxt = Math.max(curr + minJump, mx); nxt <= Math.min(curr + maxJump, n - 1); nxt++) {
                    if (visited[nxt] || chs[nxt] != '0')
                        continue;
                    q.offer(nxt);
                    visited[nxt] = true;
                }
                // 剪枝，把已经遍历过的让过去
                mx = Math.min(curr + maxJump, n - 1) + 1;
            }
        }
        return visited[n - 1];
    }
}
