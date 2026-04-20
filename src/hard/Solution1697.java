package hard;

// 1697. Checking Existence of Edge Length Limited Paths

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution1697 {

    private int[] parent;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int[][] questions = new int[queries.length][4];
        for (int i = 0; i < queries.length; i++) {
            questions[i][0] = queries[i][0];
            questions[i][1] = queries[i][1];
            questions[i][2] = queries[i][2];
            questions[i][3] = i;
        }
        Arrays.sort(questions, Comparator.comparingInt(a -> a[2]));
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        boolean[] ans = new boolean[queries.length];
        Arrays.fill(ans, true);
        int i = 0;
        for (int[] q : questions) {
            int limit = q[2];
            int idx = q[3];
            while (i < edgeList.length && edgeList[i][2] < limit) {
                int x = edgeList[i][0], y = edgeList[i][1];
                union(x, y);
                i++;
            }
            ans[idx] = find(q[0]) == find(q[1]);
        }
        return ans;
    }

    private int find(int x) {
        if (x != parent[x])
            parent[x] = find(parent[x]);
        return parent[x];
    }

    private boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py)
            return false;
        parent[px] = py;
        return true;
    }
}
