package medium;

// 2850. Minimum Moves to Spread Stones Over Grid

import java.util.ArrayList;
import java.util.List;

public class Solution2850 {
    public int minimumMoves(int[][] grid) {
        List<int[]> from = new ArrayList<>();
        List<int[]> to = new ArrayList<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) continue;
                if (grid[i][j] == 0) to.add(new int[] {i, j});
                for (int k = 0; k < grid[i][j] - 1; k++) {
                    from.add(new int[] {i, j});
                }
            }
        }
        List<List<int[]>> permutations = permutations(from);
        for (List<int[]> permutation : permutations) {
            int total = 0;
            for (int i = 0; i < permutation.size(); i ++) {
                total += manhattan(permutation.get(i), to.get(i));
            }
            ans = Math.min(ans, total);
        }
        return ans;
    }

    private int manhattan(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    private List<List<int[]>> permutations(List<int[]> l) {
        List<List<int[]>> ans = new ArrayList<>();
        dfs(0, l, ans);
        return ans;
    }

    private void dfs(int start, List<int[]> l, List<List<int[]>> ans) {
        int n = l.size();
        if (start == n) {
            ans.add(new ArrayList<>(l));
            return;
        }
        for (int i = start; i < n; i ++) {
            swap(l, i, start);
            dfs(start + 1, l, ans);
            swap(l, i, start);
        }
    }



    private void swap(List<int[]> arr, int i, int j) {
        int[] t = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, t);
    }
}
