package medium;

// 1129. Shortest Path with Alternating Colors

import java.util.*;

public class Solution1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] rg = new List[n];
        List<Integer>[] bg = new List[n];
        Arrays.setAll(rg, i -> new ArrayList<>());
        Arrays.setAll(bg, i -> new ArrayList<>());

        for (int[] e : redEdges)
            rg[e[0]].add(e[1]);
        for (int[] e : blueEdges)
            bg[e[0]].add(e[1]);

        int[] r = bfs(rg, bg, true);
        int[] b = bfs(rg, bg, false);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.min(r[i], b[i]);
            if (ans[i] == Integer.MAX_VALUE)
                ans[i] = -1;
        }
        return ans;
    }

    private int[] bfs(List<Integer>[] rg, List<Integer>[] bg, boolean red) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] rv = new boolean[rg.length];
        boolean[] bv = new boolean[bg.length];

        int[] ans = new int[rg.length];
        Arrays.fill(ans, Integer.MAX_VALUE);

        q.add(0);
        rv[0] = red;
        bv[0] = !red;
        ans[0] = 0;
        int count = 0;
        while (!q.isEmpty()) {
            int l = q.size();
            count++;
            while (l-- > 0) {
                int curr = q.poll();
                if (red) {
                    for (int nxt : rg[curr]) {
                        if (!bv[nxt]) {
                            q.offer(nxt);
                            bv[nxt] = true;
                            ans[nxt] = Math.min(ans[nxt], count);
                        }
                    }
                } else {
                    for (int nxt : bg[curr]) {
                        if (!rv[nxt]) {
                            q.offer(nxt);
                            rv[nxt] = true;
                            ans[nxt] = Math.min(ans[nxt], count);
                        }
                    }
                }
            }
            red = !red;
        }
        return ans;
    }
}
