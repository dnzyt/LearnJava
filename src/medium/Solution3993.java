package medium;

// 3993. Maximum Value of an Alternating Sequence

public class Solution3993 {
    public long maximumValue(int n, int s, int m) {
        if (n == 1)
            return s;
        return (long) s + m + (long) (m - 1) * (n / 2 - 1);
    }
}
