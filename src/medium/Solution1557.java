package medium;

// 1557. Minimum Number of Vertices to Reach All Nodes

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        for (List<Integer> e : edges) {
            int to = e.get(1);
            indegree[to]++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                ans.add(i);
        }
        return ans;
    }
}
