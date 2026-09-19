package hard;

import java.util.*;

public class Solution1520 {
    public List<String> maxNumOfSubstrings(String s) {
        char[] chs = s.toCharArray();
        int n = s.length();
        List<Integer>[] pos = new List[26];
        Arrays.setAll(pos, i -> new ArrayList<>());
        for (int i = 0; i < n; i++)
            pos[chs[i] - 'a'].add(i);

        List<Integer>[] g = new List[26];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < 26; i++) {
            if (pos[i].size() <= 1)
                continue;
            int l = pos[i].get(0), r = pos[i].get(pos[i].size() - 1);
            for (int j = 0; j < 26; j++) {
                if (i == j)
                    continue;
                int leftIdx = Collections.binarySearch(pos[j], l);
                if (leftIdx < 0)
                    leftIdx = ~leftIdx;
                if (leftIdx < pos[j].size() && pos[j].get(leftIdx) < r)
                    g[i].add(j);
            }
        }

        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (pos[i].isEmpty())
                continue;
            int[] interval = dfs(i, pos, g, new HashSet<>());
            intervals.add(interval);
        }
        Collections.sort(intervals, (a, b) -> {
            if (a[1] == b[1])
                return b[0] - a[0];
            return a[1] - b[1];
        });

        int right = 0;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            int l = intervals.get(i)[0], r = intervals.get(i)[1];
            if (l >= right) {
                ans.add(s.substring(l, r + 1));
                right = r;
            }
        }
        return ans;
    }

    private int[] dfs(int node, List<Integer>[] pos, List<Integer>[] g, Set<Integer> visited) {
        int[] res = new int[]{pos[node].get(0), pos[node].get(pos[node].size() - 1)};
        visited.add(node);
        for (int nxt : g[node]) {
            if (visited.contains(nxt))
                continue;
            int[] curr = dfs(nxt, pos, g, visited);
            res[0] = Math.min(res[0], curr[0]);
            res[1] = Math.max(res[1], curr[1]);
        }
        return res;
    }
}