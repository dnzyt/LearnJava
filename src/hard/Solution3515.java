package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 3515. Shortest Path in a Weighted Tree

public class Solution3515 {

    class FenwickTree {
        private int[] tree;

        public FenwickTree(int n) {
            tree = new int[n + 1];
        }

        public void update(int i, int delta) {
            while (i < tree.length) {
                tree[i] += delta;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int ans = 0;
            while (i > 0) {
                ans += tree[i];
                i -= lowbit(i);
            }
            return ans;
        }

        private int lowbit(int x) {
            return x & -x;
        }
    }

    private List<int[]>[] graph;
    private int[] timeIn;
    private int[] timeOut;
    private int[] dist;
    private int clock;
    private int[] weight;

    public int[] treeQueries(int n, int[][] edges, int[][] queries) {
        graph = new List[n + 1];
        Arrays.setAll(graph, i -> new ArrayList<>());

        timeIn = new int[n + 1];
        timeOut = new int[n + 1];
        weight = new int[n + 1];

        dist = new int[n + 1];

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        dfs(1, -1, 0);

        FenwickTree f = new FenwickTree(n + 1);
        List<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            int tp = query[0];
            if (tp == 1) {
                int u = query[1], v = query[2], w = query[3];
                // 选择后遍历的那个点更新
                if (timeIn[u] > timeIn[v])
                    v = u;

                f.update(timeIn[v], w - weight[timeIn[v]]);
                f.update(timeOut[v] + 1, weight[timeIn[v]] - w);
                weight[timeIn[v]] = w;
            } else if (tp == 2) {
                int x = query[1];
                ans.add(dist[x] + f.query(timeIn[x]));
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }

    private void dfs(int x, int fa, int w) {
        clock++;
        timeIn[x] = clock;
        weight[clock] = w;
        for (int[] nxt : graph[x]) {
            int nxtNode = nxt[0], nxtWeight = nxt[1];
            if (nxtNode == fa)
                continue;
            dist[nxtNode] = dist[x] + nxtWeight;
            dfs(nxtNode, x, nxtWeight);
        }
        timeOut[x] = clock;
    }
}
