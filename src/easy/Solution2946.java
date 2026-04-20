package easy;

// 2946. Matrix Similarity After Cyclic Shifts

public class Solution2946 {

    // 不管是左移还是右移，每次比较的数是同一对，所以左移也可以看成右移
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length;
        for (int[] row : mat) {
            for (int j = 0; j < n; j++)
                if (row[j] != row[(j + k) % n])
                    return false;
        }
        return true;
    }
}
