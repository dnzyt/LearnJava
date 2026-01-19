package hard;

// 3812. Minimum Edge Toggles on a Tree

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution3812 {
    public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            g[e[0]].add(new int[]{e[1], i});
            g[e[1]].add(new int[]{e[0], i});
        }
        List<Integer> res = new ArrayList<>();
        if (dfs(g, 0, -1, start.toCharArray(), target.toCharArray(), res))
            return List.of(-1);
        Collections.sort(res);
        return res;
    }

    private boolean dfs(List<int[]>[] g, int x, int fa, char[] start, char[] target, List<Integer> res) {
        boolean needRev = start[x] != target[x];
        for (int[] nxt : g[x]) {
            int nxtNode = nxt[0];
            int edgeIdx = nxt[1];
            if (nxtNode == fa)
                continue;

            if (dfs(g, nxtNode, x, start, target, res)) {
                res.add(edgeIdx);
                needRev = !needRev;
            }
        }

        return needRev;
    }
}
