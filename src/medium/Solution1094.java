package medium;

// 1094. Car Pooling

public class Solution1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] s = new int[1001];
        for (int[] t : trips) {
            s[t[1]] += t[0];
            s[t[2]] -= t[0];
        }
        int t = 0;
        for (int j : s) {
            t += j;
            if (t > capacity)
                return false;
        }
        return true;
    }
}
