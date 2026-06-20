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

        int start = 0;
        while (!q.isEmpty()) {
            int k = q.size();
            while (k-- > 0) {
                int curr = q.poll();
                for (int nxt = Math.max(curr + minJump, start); nxt <= Math.min(curr + maxJump, n - 1); nxt++) {
                    if (visited[nxt] || chs[nxt] != '0')
                        continue;
                    q.offer(nxt);
                    visited[nxt] = true;
                }
                // 剪枝，把已经遍历过的让过去
                start = Math.min(curr + maxJump, n - 1) + 1;
            }
        }
        return visited[n - 1];
    }

    // 前缀和解法
    public boolean canReach2(String s, int minJump, int maxJump) {
        char[] chs = s.toCharArray();
        int n = s.length();
        int[] f = new int[n];
        int[] presum = new int[n + 1];
        f[0] = presum[1] = 1;
        for (int i = 1; i < n; i++) {
            if (i - minJump >= 0 && chs[i] == '0' && presum[i - minJump + 1] > presum[Math.max(i - maxJump, 0)])
                f[i] = 1;
            presum[i + 1] = presum[i] + f[i];
        }
        return f[n - 1] == 1;
    }
}
