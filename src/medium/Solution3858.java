package medium;

// 3858. Minimum Bitwise OR From Grid

public class Solution3858 {
    public int minimumOR(int[][] grid) {
        int mx = 0;
        for (int[] row : grid)
            for (int x : row)
                mx = Math.max(mx, x);
        int n = 32 - Integer.numberOfLeadingZeros(mx);
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int mask = ans | (1 << i) - 1;
            for (int[] row : grid) {
                boolean findOne = false;
                for (int x : row) {
                    if ((x | mask) == mask) {
                        findOne = true;
                        break;
                    }
                }
                if (!findOne) {
                    ans |= (1 << i);
                    break;
                }
            }
        }
        return ans;
    }
}
