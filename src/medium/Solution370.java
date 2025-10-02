package medium;

// 370. Range Addition

public class Solution370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        int[] diff = new int[length + 1];
        for (int[] p : updates) {
            int start = p[0];
            int end = p[1];
            int inc = p[2];
            diff[start] += inc;
            diff[end + 1] -= inc;
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += diff[i];
            ans[i] = sum;
        }
        return ans;
    }
}
