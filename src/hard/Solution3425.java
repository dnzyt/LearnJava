package hard;

// 3425. Longest Special Path

import java.util.*;

public class Solution3425 {
    private int maxLen;
    private int minNodes;

    public int[] longestSpecialPath(int[][] edges, int[] nums) {
        int n = nums.length;
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[]{v, w});
            g[v].add(new int[]{u, w});
        }


        maxLen = -1;
        minNodes = Integer.MAX_VALUE;
        List<Integer> dis = new ArrayList<>();
        dis.add(0);
        Map<Integer, Integer> lastDepth = new HashMap<>();

        dfs(0, -1, 0, g, nums, dis, lastDepth);

        return new int[]{maxLen, minNodes};
    }

    private void dfs(int x, int fa, int topDepth, List<int[]>[] g, int[] nums, List<Integer> dis, Map<Integer, Integer> lastDepth) {
        int color = nums[x];
        int oldDepth = lastDepth.getOrDefault(color, 0);
        topDepth = Math.max(topDepth, oldDepth);
        int newLen = dis.get(dis.size() - 1) - dis.get(topDepth);
        int newNodes = dis.size() - topDepth;
        if (newLen > maxLen) {
            maxLen = newLen;
            minNodes = newNodes;
        } else if (newLen == maxLen && newNodes < minNodes)
            minNodes = newNodes;
        lastDepth.put(color, dis.size());
        for (int[] nxt : g[x]) {
            if (nxt[0] == fa)
                continue;
            dis.add(dis.get(dis.size() - 1) + nxt[1]);
            dfs(nxt[0], x, topDepth, g, nums, dis, lastDepth);
            dis.remove(dis.size() - 1);
        }
        lastDepth.put(color, oldDepth);
    }


}
