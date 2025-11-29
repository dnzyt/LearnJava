package hard;

// 2127. Maximum Employees to Be Invited to a Meeting

import java.util.*;

public class Solution2127 {
    // 基环树
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        List<Integer>[] rg = new List[n]; // 用来建树枝上的返图
        Arrays.setAll(rg, i -> new ArrayList<>());

        int[] inDeg = new int[n];
        for (int f : favorite)
            inDeg[f]++;

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0)
                q.offer(i);
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            rg[favorite[curr]].add(curr);
            inDeg[favorite[curr]]--;
            if (inDeg[favorite[curr]] == 0)
                q.offer(favorite[curr]);
        }

        int maxRingSize = 0;
        int sumTreeSize = 0;
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0)
                continue;
            int curr = i;
            int s = 0;
            while (inDeg[curr] != 0) {
                inDeg[curr] = 0;
                curr = favorite[curr];
                s++;
            }
            if (s == 2) {
                sumTreeSize += (dfs(rg, i) + dfs(rg, favorite[i]));
            } else {
                maxRingSize = Math.max(maxRingSize, s);
            }
        }
        return Math.max(maxRingSize, sumTreeSize);
    }

    // 计算基环树的树枝最大长度
    private int dfs(List<Integer>[] g, int i) {
        int ans = 0;
        for (int nxt : g[i]) {
            ans = Math.max(ans, dfs(g, nxt));
        }
        return ans + 1;
    }

}
