package hard;

// 3382. Maximum Area Rectangle With Point Constraints II

import util.FenwickTree;

import java.util.Arrays;

public class Solution3382 {
    public long maxRectangleArea(int[] xCoord, int[] yCoord) {
        int n = xCoord.length;
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = xCoord[i];
            points[i][1] = yCoord[i];
        }
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Arrays.sort(yCoord);

        FenwickTree tree = new FenwickTree(n);
        int[][] p = new int[n][3]; // [bottomX, bottomY, cnt]
        tree.update(Arrays.binarySearch(yCoord, points[0][1]) + 1, 1);
        long res = -1L;
        for (int i = 1; i < n; i++) {
            int x1 = points[i - 1][0], y1 = points[i - 1][1];
            int x2 = points[i][0], y2 = points[i][1];

            int y = Arrays.binarySearch(yCoord, y2);
            tree.update(y + 1, 1);
            if (x1 != x2)
                continue;
            int leftBottomX = p[y][0], leftBottomY = p[y][1], preCnt = p[y][2];
            int currCnt = tree.query(y + 1) - tree.query(Arrays.binarySearch(yCoord, y1));
            if (preCnt > 0 && leftBottomY == y1 && preCnt + 2 == currCnt)
                res = Math.max(res, (long) (x2 - leftBottomX) * (y2 - y1));
            p[y][0] = x1;
            p[y][1] = y1;
            p[y][2] = currCnt;
        }
        return res;
    }
}
