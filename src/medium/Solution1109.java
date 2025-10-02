package medium;

// 1109. Corporate Flight Bookings

public class Solution1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 2];
        for (int[] b : bookings) {
            diff[b[0]] += b[2];
            diff[b[1] + 1] -= b[2];
        }
        int s = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            s += diff[i + 1];
            ans[i] = s;
        }
        return ans;
    }
}
