package hard;

import util.DiffArray2D;

import java.util.*;

// 850. Rectangle Area II

public class Solution850 {
    public int rectangleArea(int[][] rectangles) {
        final long M = 1000000007;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (int[] rec : rectangles) {
            rowSet.add(rec[0]);
            colSet.add(rec[1]);
            rowSet.add(rec[2]);
            colSet.add(rec[3]);
        }
        int m = rowSet.size(), n = colSet.size();
        List<Integer> rowSorted = new ArrayList<>(rowSet);
        Collections.sort(rowSorted);
        List<Integer> colSorted = new ArrayList<>(colSet);
        Collections.sort(colSorted);

        HashMap<Integer, Integer> rowVal2Idx = new HashMap<>();
        HashMap<Integer, Integer> colVal2Idx = new HashMap<>();

        for (int i = 0; i < rowSorted.size(); i++)
            rowVal2Idx.put(rowSorted.get(i), i);


        for (int j = 0; j < colSorted.size(); j++)
            colVal2Idx.put(colSorted.get(j), j);


        DiffArray2D diffArr = new DiffArray2D(m, n);

        for (int[] rectangle : rectangles) {
            int x0 = rowVal2Idx.get(rectangle[0]);
            int y0 = colVal2Idx.get(rectangle[1]);
            int x1 = rowVal2Idx.get(rectangle[2]);
            int y1 = colVal2Idx.get(rectangle[3]);
            diffArr.flood(x0, y0, x1 - 1, y1 - 1);
        }
        diffArr.compute();
        long res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (diffArr.f[i][j] > 0) {
                    long x0 = rowSorted.get(i);
                    long y0 = colSorted.get(j);
                    long x1 = rowSorted.get(i + 1);
                    long y1 = colSorted.get(j + 1);
                    res += ((x1 - x0) * (y1 - y0) % M);
                }
        return (int) (res % M);
    }

}
