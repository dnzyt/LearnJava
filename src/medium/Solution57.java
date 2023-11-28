package medium;

// 57. Insert Interval

import java.util.Arrays;
import java.util.stream.Stream;

public class Solution57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        int start = newInterval[0], end = newInterval[1];
        int left_idx = Arrays.binarySearch(starts, start);
        left_idx = left_idx < 0 ? ~left_idx : left_idx;
        int right_idx = Arrays.binarySearch(ends, end);
        right_idx = right_idx < 0 ? ~right_idx : right_idx;

        if (left_idx > 0 && ends[left_idx - 1] >= start) {
            start = starts[left_idx - 1];
            left_idx -= 1;
        }
        if (right_idx < n && end >= starts[right_idx]) {
            end = ends[right_idx];
            right_idx += 1;
        }
        Stream<int[]> first = Arrays.stream(intervals, 0, left_idx);
        Stream<int[]> second = Arrays.stream(new int[][] { { start ,end } });
        Stream<int[]> third = Arrays.stream(intervals, right_idx, n);

        return Stream.of(first, second, third).flatMap(s -> s).toArray(int[][]::new);

    }

}
