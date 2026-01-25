package hard;

// 3821. Find Nth Smallest Integer With K One Bits

public class Solution3821 {

    private static final int MX = 50;
    private static final long[][] COMBO = new long[MX][MX + 1];
    private static boolean initialized = false;

    public Solution3821() {
        if (initialized)
            return;
        initialized = true;
        for (int i = 0; i < MX; i++) {
            COMBO[i][0] = 1L;
            for (int j = 1; j <= i; j++)
                COMBO[i][j] = COMBO[i - 1][j - 1] + COMBO[i - 1][j];
        }
    }

    public long nthSmallest(long n, int k) {
        long ans = 0L;
        for (int i = MX - 1; k > 0; i--) {
            if (COMBO[i][k] < n) {
                ans |= (1L << i);
                n -= COMBO[i][k];
                k--;
            }
        }
        return ans;
    }
}
