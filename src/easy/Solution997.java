package easy;

// 997. Find the Town Judge

public class Solution997 {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        for (int[] x : trust) {
            in[x[1]]++;
            out[x[0]]++;
        }
        for (int i = 1; i <= n; i++)
            if (in[i] == n - 1 && out[i] == 0)
                return i;
        return -1;
    }
}
