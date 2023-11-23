package hard;


// 630. Course Schedule III

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution630 {
    // 先可deadline近的处理
    // 如果遇到超过deadline的课程，去掉目前为止最耗时的课程
    static class Course implements Comparable<Course> {
        int duration;
        int lastDay;

        public Course(int d, int l) {
            this.duration = d;
            this.lastDay = l;
        }

        @Override
        public int compareTo(Course o) {
            return o.duration - this.duration;
        }
    }

    public int scheduleCourse(int[][] courses) {
        List<Course> crs = new ArrayList<>();
        for (int[] course : courses) {
            crs.add(new Course(course[0], course[1]));
        }
        crs.sort((a, b) -> a.lastDay - b.lastDay);
        PriorityQueue<Course> pq = new PriorityQueue<>();

        int res = 0;
        int days = 0;
        for (Course c : crs) {
            days += c.duration;
            pq.add(c);
            res ++;
            if (days > c.lastDay) {
                days -= pq.poll().duration;
                res --;
            }
        }
        return res;
    }

}
