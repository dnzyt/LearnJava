package hard;

// 2127. Maximum Employees to Be Invited to a Meeting

import javafx.util.Pair;

import java.util.*;

public class Solution2127 {
    // 我的眼里只有你
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegrees = new int[n];
        int[] depth = new int[n];
        Arrays.fill(depth, 1);
        int res = 0;
        Set<Pair<Integer, Integer>> pairs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            indegrees[favorite[i]] += 1;
            if (i == favorite[favorite[i]] && !pairs.contains(new Pair<>(favorite[i], i)))
                pairs.add(new Pair<>(i, favorite[i]));
        }
        Queue<Integer> q = new LinkedList<>();
        // 剥洋葱的时候可以记录每个节点的深度
        int steps = 1;
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int l = q.size();
            steps ++;
            while (l > 0) {
                int curr = q.poll();
                l --;
                int nxt = favorite[curr];
                indegrees[nxt] -= 1;
                depth[nxt] = steps;
                if (indegrees[nxt] == 0) {
                    q.offer(nxt);
                }
            }
        }
        for (Pair<Integer, Integer> pair : pairs) {
            res += depth[pair.getKey()];
            res += depth[pair.getValue()];
        }
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0 || visited[i] == 1) continue;
            res = Math.max(res, dfs(i, favorite, indegrees, visited));
        }

        return res;
    }

    private int dfs(int curr, int[] fav, int[] indegrees, int[] visited) {
        if (indegrees[curr] == 0 || visited[curr] == 1) return 0;
        visited[curr] = 1;
        return 1 + dfs(fav[curr], fav, indegrees, visited);
    }

}
