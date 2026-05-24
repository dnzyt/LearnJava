package hard;

// 1345. Jump Game IV

import java.util.*;

public class Solution1345 {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Deque<Integer> q = new ArrayDeque<>();
        int steps = 0;
        boolean[] visited = new boolean[n];
        q.offer(0);
        visited[0] = true;
        Map<Integer, List<Integer>> nxt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!nxt.containsKey(arr[i]))
                nxt.put(arr[i], new ArrayList<>());
            nxt.get(arr[i]).add(i);
        }

        while (!q.isEmpty()) {
            int len = q.size();
            steps++;
            while (len-- > 0) {
                int curr = q.poll();
                if (curr == n - 1)
                    return steps;
                if (curr + 1 < n && !visited[curr + 1]) {
                    q.offer(curr + 1);
                    visited[curr + 1] = true;
                }
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    q.offer(curr - 1);
                    visited[curr - 1] = true;
                }
                if (nxt.containsKey(arr[curr])) {
                    for (int nxtMove : nxt.get(arr[curr])) {
                        if (!visited[nxtMove]) {
                            q.offer(nxtMove);
                            visited[nxtMove] = true;
                        }
                    }
                    // 要把遍历过的点彻底删掉，不然超时
                    // 相同值对应的索引已经加到队列了，不用再加一遍
                    nxt.remove(arr[curr]);
                }
            }
        }
        return -1;
    }
}
