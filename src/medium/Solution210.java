package medium;

// 210. Course Schedule II

import java.util.*;

public class Solution210 {

    // 拓扑排序 - BFS + Queue
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer>[] g = new List[numCourses];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            g[pre[1]].add(pre[0]);
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) {
                q.offer(i);
                visited[i] = true;
            }

        while (!q.isEmpty()) {
            Queue<Integer> t = new ArrayDeque<>();
            while (!q.isEmpty()) {
                Integer curr = q.poll();
                ans.add(curr);
                for (int nxt : g[curr]) {
                    indegree[nxt]--;
                    if (!visited[nxt] && indegree[nxt] == 0) {
                        t.offer(nxt);
                        visited[nxt] = true;
                    }
                }
            }
            q = t;
        }
        if (ans.size() < numCourses)
            return new int[]{};

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }


}
