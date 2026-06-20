package easy;

// 2923. Find Champion I

public class Solution2923 {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            boolean found = true;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (grid[i][j] == 0) {
                    found = false;
                    break;
                }
            }
            if (found)
                return i;
        }
        return -1;
    }
}
