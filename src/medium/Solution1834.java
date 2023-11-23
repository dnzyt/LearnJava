package medium;

// 1834. Single-Threaded CPU

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1834 {

    static class Task implements Comparable<Task> {
        int enqueueTime;
        int processingTime;
        int index;

        public Task(int e, int p, int idx) {
            this.enqueueTime = e;
            this.processingTime = p;
            this.index = idx;
        }

        @Override
        public int compareTo(Task o) {
            if (this.processingTime != o.processingTime)
                return this.processingTime - o.processingTime;
            else
                return this.index - o.index;
        }
    }

    public int[] getOrder(int[][] tasks) {
        List<Task> cTasks = new ArrayList<>();
        int currentTime = 0;
        for (int i = 0; i < tasks.length; i++) {
            cTasks.add(new Task(tasks[i][0], tasks[i][1], i));
        }
        cTasks.sort((a, b) -> {
            if (a.enqueueTime != b.enqueueTime)
                return a.enqueueTime - b.enqueueTime;
            else if (a.processingTime != b.processingTime)
                return a.processingTime - b.processingTime;
            else
                return a.index - b.index;
        });
        PriorityQueue<Task> pq = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>();
        for (Task task : cTasks) {
            while (currentTime < task.enqueueTime && !pq.isEmpty()) {
                Task t = pq.poll();
                res.add(t.index);
                currentTime += t.processingTime;
            }
            currentTime = Math.max(currentTime, task.enqueueTime);
            pq.add(task);
        }
        while (!pq.isEmpty())
            res.add(pq.poll().index);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
