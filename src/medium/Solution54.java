package medium;

// 54. Spiral Matrix

import java.util.ArrayList;

import java.util.List;
import java.util.stream.IntStream;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        return surrond(matrix);
    }

    private List<Integer> surrond(int[][] mat) {
        int m = mat.length;
        if (m == 0)
            return new ArrayList<>();
        int n = mat[0].length;
        if (n == 0)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>(IntStream.of(mat[0]).boxed().toList());
        if (m > 1) {
            for (int i = 1; i < m; i++)
                res.add(mat[i][n - 1]);
            if (n > 1) {
                for (int j = n - 2; j >= 0; j--) {
                    res.add(mat[m - 1][j]);
                }
                for (int i = m - 2; i >= 1; i--) {
                    res.add(mat[i][0]);
                }
            }
        }
        if (n <= 2)
            return res;
        List<int[]> newMat = new ArrayList<>();
        for (int i = 1; i < m - 1; i++) {
            int[] temp = new int[n - 2];
            System.arraycopy(mat[i], 1, temp, 0, n - 1 - 1);
            newMat.add(temp);
        }
        int[][] a = newMat.toArray(int[][]::new);

        res.addAll(surrond(a));
        return res;
    }

}
