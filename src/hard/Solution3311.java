package hard;

// 3311. Construct 2D Grid Matching Graph Layout

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3311 {
    public int[][] constructGridLayout(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        int[] degreeToNode = new int[5];
        Arrays.fill(degreeToNode, -1);
        for (int node = 0; node < n; node++)
            degreeToNode[g[node].size()] = node;

        List<Integer> row = new ArrayList<>();
        if (degreeToNode[1] != -1)
            row.add(degreeToNode[1]);
        else if (degreeToNode[4] == -1) {
            int x = degreeToNode[2];
            for (int y : g[x]) {
                if (g[y].size() == 2) {
                    row.add(x);
                    row.add(y);
                    break;
                }
            }
        } else { // 2 333.. 33 2
            int x = degreeToNode[2];
            row.add(x);
            int pre = x;
            x = g[x].get(0);
            while (g[x].size() == 3) {
                row.add(x);
                for (int y : g[x]) {
                    if (y != pre && g[y].size() < 4) {
                        pre = x;
                        x = y;
                        break;
                    }
                }
            }
            row.add(x);
        }
        int m = n / row.size();
        int[][] ans = new int[m][row.size()];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < row.size(); i++) {
            int x = row.get(i);
            ans[0][i] = x;
            visited[x] = true;
        }

        for (int i = 1; i < ans.length; i++) {
            for (int j = 0; j < row.size(); j++) {
                for (int y : g[ans[i - 1][j]]) {
                    if (!visited[y]) {
                        ans[i][j] = y;
                        visited[y] = true;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
