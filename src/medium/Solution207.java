package medium;

// 207. Course Schedule

import java.util.*;

public class Solution207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++)
            graph.put(i, new ArrayList<>());
        for (int[] pre : prerequisites) {
            indegrees[pre[0]] += 1;
            graph.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int visited = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            visited += 1;
            for (Integer nxt : graph.get(curr)) {
                indegrees[nxt] --;
                if (indegrees[nxt] == 0)
                    q.offer(nxt);
            }
        }

        return visited == numCourses;




    }

}
