package hard;

// 3841. Palindromic Path Queries in a Tree

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3841 {

    class FenwickTree {
        private int[] tree;

        public FenwickTree(int n) {
            tree = new int[n];
        }

        public void update(int i, int delta) {
            while (i < tree.length) {
                tree[i] ^= delta;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int ans = 0;
            while (i > 0) {
                ans ^= tree[i];
                i -= lowbit(i);
            }
            return ans;
        }

        private int lowbit(int i) {
            return i & -i;
        }
    }


    class LCABinaryLifting {
        private List<Integer>[] graph;
        private int[][] pa;
        private int[] depth;
        public int[] xorFromRoot;
        private char[] chs;
        private int[] timeIn;
        private int[] timeOut;
        private int clock;

        // n个节点，n-1条边
        public LCABinaryLifting(int[][] edges, String s) {
            chs = s.toCharArray();
            int n = edges.length + 1;
            int m = 32 - Integer.numberOfLeadingZeros(n);

            graph = new List[n];
            Arrays.setAll(graph, i -> new ArrayList<>());
            pa = new int[n][m];
            for (int i = 0; i < n; i++)
                Arrays.fill(pa[i], -1);

            depth = new int[n];
            xorFromRoot = new int[n];
            timeIn = new int[n];
            timeOut = new int[n];


            for (int[] e : edges) {
                int u = e[0], v = e[1];
                graph[u].add(v);
                graph[v].add(u);
            }

            dfs(0, -1);
            for (int i = 1; i < m; i++)
                for (int j = 0; j < n; j++) {
                    int ancestorNode = pa[j][i - 1];
                    if (ancestorNode != -1)
                        pa[j][i] = pa[ancestorNode][i - 1];
                }

        }

        private void dfs(int i, int fa) {
            pa[i][0] = fa;
            clock++;
            timeIn[i] = clock;
            for (int nxt : graph[i]) {
                if (nxt == fa)
                    continue;
                depth[nxt] = depth[i] + 1;
                xorFromRoot[nxt] = xorFromRoot[i] ^ (1 << (chs[nxt] - 'a'));
                dfs(nxt, i);
            }
            timeOut[i] = clock;
        }

        private int getKthAncestor(int x, int k) {
            int m = 32 - Integer.numberOfLeadingZeros(k);
            for (int i = 0; i < m; i++) {
                if (((k >> i) & 1) > 0) {
                    x = pa[x][i];
                    if (x < 0)
                        return -1;
                }
            }
            return x;
        }

        public int getLCA(int x, int y) {
            if (depth[x] > depth[y]) {
                int temp = x;
                x = y;
                y = temp;
            }

            y = getKthAncestor(y, depth[y] - depth[x]);
            if (x == y)
                return x;
            for (int i = pa[0].length - 1; i >= 0; i--) {
                int px = pa[x][i], py = pa[y][i];
                if (px != py) {
                    x = px;
                    y = py;
                }
            }
            return pa[x][0];
        }
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        char[] currS = s.toCharArray();
        LCABinaryLifting lcaBL = new LCABinaryLifting(edges, s);
        FenwickTree f = new FenwickTree(n + 1);

        List<Boolean> ans = new ArrayList<>();
        for (String query : queries) {
            String[] s1 = query.split(" ");
            if ("update".equals(s1[0])) {
                int node = Integer.parseInt(s1[1]);
                char c = s1[2].charAt(0);
                if (currS[node] == c)
                    continue;
                int val = (1 << (c - 'a')) | (1 << (currS[node] - 'a'));
                currS[node] = c;
                f.update(lcaBL.timeIn[node], val);
                f.update(lcaBL.timeOut[node] + 1, val);


            } else if ("query".equals(s1[0])) {
                int startNode = Integer.parseInt(s1[1]), endNode = Integer.parseInt(s1[2]);
                int lca = lcaBL.getLCA(startNode, endNode);
                int startXOR = lcaBL.xorFromRoot[startNode] ^ f.query(lcaBL.timeIn[startNode]);
                int endXOR = lcaBL.xorFromRoot[endNode] ^ f.query(lcaBL.timeIn[endNode]);
                int xor = startXOR ^ endXOR ^ (1 << (currS[lca] - 'a'));
                ans.add((xor & (xor - 1)) == 0);
            }
        }
        return ans;
    }
}
