package medium;

// 3380. Maximum Area Rectangle With Point Constraints I

import util.FenwickTree;

import java.util.*;

public class Solution3380 {
    public int maxRectangleArea(int[][] points) {
        int n = points.length;
        List<Integer> ts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ts.add(points[i][1]);
        }
        Arrays.sort(points, Comparator.<int[]>comparingInt(a -> a[0])
                .thenComparingInt(a -> a[1]));
        int[] ys = new ArrayList<>(ts)
                .stream()
                .mapToInt(Integer::intValue).toArray();
        Arrays.sort(ys);

        FenwickTree tree = new FenwickTree(ys.length);
        tree.update(Arrays.binarySearch(ys, points[0][1]) + 1, 1);
        int[][] p = new int[n + 1][3];
        int res = -1;
        for (int i = 1; i < n; i++) {
            int[] prePoint = points[i - 1];
            int[] currPoint = points[i];
            int y = Arrays.binarySearch(ys, currPoint[1]);
            tree.update(y + 1, 1);
            if (prePoint[0] != currPoint[0])
                continue;
            int currCnt = tree.query(y + 1) - tree.query(Arrays.binarySearch(ys, prePoint[1]) - 1);
            int leftBottomX = p[y + 1][0];
            int leftBottomY = p[y + 1][1];
            int precnt = p[y + 1][2];
            if (precnt > 0 && precnt + 2 == currCnt && leftBottomY == prePoint[1])
                res = Math.max(res, (currPoint[0] - leftBottomX) * (currPoint[1] - prePoint[1]));
            p[y + 1][0] = prePoint[0];
            p[y + 1][1] = prePoint[1];
            p[y + 1][2] = currCnt;
        }
        return res;
    }


}
