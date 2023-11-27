package medium;

// 210. Course Schedule II

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution210 {

    // 拓扑排序 - BFS + Queue
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            indegrees[pre[0]] += 1;
            graph.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
                res.add(i);
            }
        }

        while (!q.isEmpty()) {
            int l = q.size();
            while (l != 0) {
                int curr = q.poll();
                l -= 1;
                for (Integer nxt : graph.get(curr)) {
                    indegrees[nxt] -= 1;
                    if (indegrees[nxt] == 0) {
                        q.offer(nxt);
                        res.add(nxt);
                    }

                }
            }
        }
        if (res.size() != numCourses)
            return new int[0];
        return res.stream().mapToInt(Integer::intValue).toArray();

    }


}
