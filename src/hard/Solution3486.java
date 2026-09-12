package hard;

// 3486. Longest Special Path II

import java.util.*;

public class Solution3486 {
    private List<int[]>[] g;
    private List<Integer> dis;
    private int[] nums;
    private Map<Integer, Integer> lastDepth;
    private int maxLen;
    private int minNodes;

    public int[] longestSpecialPath(int[][] edges, int[] nums) {
        this.nums = nums;
        lastDepth = new HashMap<>();
        dis = new ArrayList<>();
        dis.add(0);
        int n = nums.length;
        g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[]{v, w});
            g[v].add(new int[]{u, w});
        }
        dfs(0, -1, 0, 0);
        return new int[] {maxLen, minNodes};
    }

    private void dfs(int x, int fa, int topDepth, int last2) {
        int color = nums[x];
        int oldDepth = lastDepth.getOrDefault(color, 0);
        topDepth = Math.max(topDepth, Math.min(oldDepth, last2));
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
            dfs(nxt[0], x, topDepth, Math.max(oldDepth, last2));
            dis.remove(dis.size() - 1);
        }
        lastDepth.put(color, oldDepth);
    }


}
