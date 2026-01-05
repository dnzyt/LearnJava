package hard;

// 2977. Minimum Cost to Convert String II

import java.util.Arrays;


public class Solution2977 {
    class Node {
        public Node[] children = new Node[26];
        public int sid = -1;
    }

    private Node root;
    private int seq = 0;
    private char[] source;
    private char[] target;
    private int[][] dist;
    private long[] memo;

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        this.source = source.toCharArray();
        this.target = target.toCharArray();
        root = new Node();
        int n = cost.length;
        dist = new int[n * 2][n * 2];
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
            dist[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            int x = put(original[i]);
            int y = put(changed[i]);
            dist[x][y] = Math.min(dist[x][y], cost[i]);
        }

        for (int k = 0; k < seq; k++)
            for (int i = 0; i < seq; i++) {
                if (dist[i][k] == Integer.MAX_VALUE / 2)
                    continue;
                for (int j = 0; j < seq; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
            }

        memo = new long[source.length()];
        Arrays.fill(memo, -1L);
        long ans = dfs(0);
        return ans == Long.MAX_VALUE / 2 ? -1 : ans;
    }

    private long dfs(int i) {
        if (i == source.length)
            return 0;
        if (memo[i] != -1L)
            return memo[i];
        long ans = Long.MAX_VALUE / 2;

        if (source[i] == target[i])
            ans = dfs(i + 1);
        Node pCurr = root;
        Node qCurr = root;
        for (int j = i; j < source.length; j++) {
            pCurr = pCurr.children[source[j] - 'a'];
            qCurr = qCurr.children[target[j] - 'a'];
            if (pCurr == null || qCurr == null)
                break;
            if (pCurr.sid == -1 || qCurr.sid == -1)
                continue;
            int d = dist[pCurr.sid][qCurr.sid];
            if (d < Integer.MAX_VALUE / 2)
                ans = Math.min(ans, d + dfs(j + 1));
        }
        return memo[i] = ans;
    }


    private int put(String s) {
        Node curr = root;
        for (char c : s.toCharArray()) {
            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new Node();
            curr = curr.children[c - 'a'];
        }
        if (curr.sid == -1)
            curr.sid = seq++;
        return curr.sid;
    }
}
