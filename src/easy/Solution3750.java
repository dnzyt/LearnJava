package easy;

// 3750. Minimum Number of Flips to Reverse Binary String

public class Solution3750 {
    public int minimumFlips(int n) {
        int x = Integer.reverse(n) >>> Integer.numberOfLeadingZeros(n);
        return Integer.bitCount(x ^ n);
    }
}
